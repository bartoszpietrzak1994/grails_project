package grails

class UrlMappings {

    static mappings = {
        "/shop/login" {
            controller = { "user" }
            action = [ GET: "shopUserLoginView" ]
        }

        "/shop/login" {
            controller = { "user" }
            action = [ POST: "Logging" ]
        }

        "/shop/register" {
            controller = { "user" }
            action = [ GET: "shopUserRegisterView" ]
        }

        "/admin/login" {
            controller = { "user" }
            action = [ GET: "adminUserLoginView" ]
        }

        "/admin/register" {
            controller = { "user" }
            action = [ GET: "adminUserRegisterView" ]
        }

        "/admin/register" {
            controller = { "user" }
            action = [ POST: "adminUserRegister" ]
        }

        "/admin/users" {
            controller = { "user" }
            action = [ GET: "users" ]
        }

        "/registrationConfirm/*" {
            controller = { "user" }
            action = [ POST: "confirmRegistration" ]
        }

        "/" (uri: "/shop/login")
        "500"(view:'/error')
        "404"(view:'/error')
    }
}
