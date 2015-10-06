package com.iai

class UserPrincipleController {

    def springSecurityService

    Map index() {
        org.springframework.security.core.userdetails.User foo = springSecurityService.principal
        println foo.username
        def bar = foo.authorities
        println bar[0].authority
        println foo.properties
        render "${[username: foo.username, roles: foo.authorities*.authority]}"
    }
}
