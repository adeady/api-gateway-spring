import com.iai.auth.SecUser
import com.iai.auth.SecRole
import com.iai.auth.SecUserSecRole
import grails.auth.service.ProtectedResource

class BootStrap {

    def init = { servletContext ->

        new ProtectedResource(name: "foo", description: "bar").save()
        new ProtectedResource(name: "rainy", description: "this sucks").save()

        def adeady = new SecUser(username: "adeady", password: "password").save()
        def userRole = new SecRole(authority: "ROLE_USER").save()

        SecUserSecRole.create(adeady, userRole, true)


    }
    def destroy = {
    }
}
