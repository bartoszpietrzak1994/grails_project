package grails

class UrlMappings {

    static mappings = {
        "/login" {
            controller = { "user" }
            action = [ GET: "loginView" ]
        }

        "/shop/register" {
            controller = { "user" }
            action = [ GET: "shopUserRegisterView" ]
        }

        "/shop/index" {
            controller = { "user" }
            action = [ GET: "shopUserIndex" ]
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

        "/admin/index" {
            controller = { "user" }
            action = [ GET: "adminUserIndex" ]
        }

        "/registrationConfirm/*" {
            controller = { "user" }
            action = [ POST: "confirmRegistration" ]
        }

        "/" (uri: "/login")
        "500"(view:'/error')
        "404"(view:'/error')
    }
}
