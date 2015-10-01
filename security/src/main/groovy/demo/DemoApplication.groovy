package demo
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer

@SpringBootApplication
@EnableResourceServer //secures everything except for /oauth endpoints
public class DemoApplication {

    public static void main(String[] args) {
        println "ANGIE!!!! ${Class.forName("org.h2.Driver")}"
        SpringApplication.run(DemoApplication.class, args);
    }

}
