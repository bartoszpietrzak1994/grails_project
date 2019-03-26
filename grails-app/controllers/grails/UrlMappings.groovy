package grails

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/admin/users"(resources: 'user')

        "/"(view:"/user/shopUserLoginView")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
