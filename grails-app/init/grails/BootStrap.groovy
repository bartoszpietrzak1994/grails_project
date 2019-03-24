package grails

import user.User
import user.UserRole

class BootStrap {

    def init = { servletContext ->
        if (UserRole.count() == 0) {
            new UserRole(authority: "User").save(flush: true, failOnError: true)
            new UserRole(authority: "Admin").save(flush: true, failOnError: true)
        }

        if (User.count() == 0) {
            new User(email: "sample_admin_user@example.com", password: "sample", enabled: true, userRoles: [UserRole.findByAuthority("Admin")]).save(flush: true, failOnError: true)
            new User(email: "sample_user@example.com", password: "sample", enabled: true, userRoles: [UserRole.findByAuthority("User")]).save(flush: true, failOnError: true)
        }

    }
    def destroy = {
    }
}
