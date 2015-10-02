import grails.auth.service.UsersController

class UrlMappings {

	static mappings = {
        "/api/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }



        "/api/angie"(controller: UsersController)

        "/user"(controller: UsersController)

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
