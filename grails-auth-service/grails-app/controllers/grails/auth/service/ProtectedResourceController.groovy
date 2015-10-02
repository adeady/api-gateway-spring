package grails.auth.service

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

@Secured(['ROLE_USER'])
class ProtectedResourceController extends RestfulController {

    static responseFormats = ['json', 'xml']

    ProtectedResourceController() {
        super(ProtectedResource)
    }
}
