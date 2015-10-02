package grails.auth.service

import grails.plugin.springsecurity.annotation.Secured

import java.security.Principal

class UsersController {


    @Secured(['ROLE_USER'])
    public def index() {
        render "I R HERE"
    }
}
