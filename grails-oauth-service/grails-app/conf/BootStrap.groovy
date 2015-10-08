import com.iai.Client
import com.iai.User
import com.iai.UserRole
import com.iai.Role

class BootStrap {

    def init = { servletContext ->
        Role roleUser = new Role(authority: 'ROLE_USER').save(flush: true)

        User user = new User(
                username: 'user',
                password: 'password',
                enabled: true,
                accountExpired: false,
                accountLocked: false,
                passwordExpired: false
        ).save(flush: true)

        UserRole.create(user, roleUser, true)

        new Client(
                clientId: 'my-client',
                authorizedGrantTypes: ['authorization_code', 'refresh_token', 'implicit', 'password', 'client_credentials'],
                authorities: ['ROLE_CLIENT'],
                scopes: ['read', 'write'],
                redirectUris: ['http://example.com']
        ).save(flush: true)

        println Client.list()
    }
    def destroy = {
    }
}
