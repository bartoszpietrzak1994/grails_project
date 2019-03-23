package grails

import user.User
import user.UserRole

class BootStrap {

    def init = { servletContext ->
        if (UserRole.count() == 0) {
            new UserRole(roleName: "User").save(flush: true)
            new UserRole(roleName: "Admin").save(flush: true)
        }

        if (User.count() == 0) {
            new User(email: "sample_admin_user@example.com", password: "sample", enabled: true, userRoles: [UserRole.findByRoleName("Admin")]).save(flush: true)
            new User(email: "sample_user@example.com", password: "sample", enabled: true, userRoles: [UserRole.findByRoleName("User")]).save(flush: true)
        }

    }
    def destroy = {
    }
}
