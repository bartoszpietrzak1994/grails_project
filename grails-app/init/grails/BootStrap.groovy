package grails


import user.UserRole

class BootStrap {

    def init = { servletContext ->
        if (UserRole.count() == 0) {
            new UserRole(authority: "ROLE_USER").save(flush: true, failOnError: true)
            new UserRole(authority: "ROLE_ADMIN").save(flush: true, failOnError: true)
        }
    }
    def destroy = {
    }
}
