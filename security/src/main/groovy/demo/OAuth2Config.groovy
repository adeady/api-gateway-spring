package demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore

import javax.sql.DataSource

//tell the app that we are an oauth server
@Configuration
@EnableAuthorizationServer
class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired AuthenticationManager authenticationManager;

    @Autowired DataSource dataSource

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Bean
    JdbcTokenStore tokenStore() {
        new JdbcTokenStore(dataSource)
    }

    @Bean
    AuthorizationCodeServices authorizationCodeServices() {
        new JdbcAuthorizationCodeServices(dataSource);
    }

    @Override
    void configure(AuthorizationServerSecurityConfigurer security) {
        security.passwordEncoder(passwordEncoder)
    }

    @Override
    void configure(AuthorizationServerEndpointsConfigurer endpoints) {
//        endpoints.authenticationManager(authenticationManager)
        endpoints.authorizationCodeServices(authorizationCodeServices())
                .authenticationManager(authenticationManager).tokenStore(tokenStore())
                .approvalStoreDisabled();
    }

    @Override
    void configure(ClientDetailsServiceConfigurer clients) {
        //define clients todo: this should be externalized!!!
        clients.jdbc(dataSource)
                .passwordEncoder(passwordEncoder)
                .withClient("acme")
                .secret("acmesecret")
                .authorizedGrantTypes("authorization_code", "refresh_token",
                "password").scopes("openid");
    }
}
