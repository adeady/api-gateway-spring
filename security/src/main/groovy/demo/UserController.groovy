package demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import java.security.Principal

@RestController
class UserController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        user
    }

}
