import com.iai.auth.SecUser
import com.iai.auth.SecRole
import com.iai.auth.SecUserSecRole

class BootStrap {

    def init = { servletContext ->

        def adeady = new SecUser(username: "adeady", password: "password").save()
        def userRole = new SecRole(authority: "ROLE_USER").save()

        SecUserSecRole.create(adeady, userRole, true)

    }
    def destroy = {
    }
}
