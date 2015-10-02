import grails.auth.service.UsersController

class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }


        "/user"(controller: UsersController)

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
