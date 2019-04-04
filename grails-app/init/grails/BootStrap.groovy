package grails


import user.User
import user.UserRole
import user.UserUserRole

class BootStrap {

    def init = { servletContext ->

        if (UserRole.count() == 0) {
            new UserRole(authority: "ROLE_USER").save(flush: true, failOnError: true)
            new UserRole(authority: "ROLE_ADMIN").save(flush: true, failOnError: true)
        }

        if (User.count() == 0) {
            new User(
                    username: "sample_admin_user@example.com",
                    email: "sample_admin_user@example.com",
                    password: "sample",
                    enabled: true
            ).save(flush: true, failOnError: true)

            new User(
                    username: "sample_user@example.com",
                    email: "sample_user@example.com",
                    password: "sample",
                    enabled: true
            ).save(flush: true, failOnError: true)
        }

        new UserUserRole(
                user: User.findByUsername("sample_admin_user@example.com"),
                userRole: UserRole.findByAuthority("ROLE_ADMIN")
        ).save(flush: true, failOnError: true)

        new UserUserRole(
                user: User.findByUsername("sample_user@example.com"),
                userRole: UserRole.findByAuthority("ROLE_USER")
        ).save(flush: true, failOnError: true)
    }
    def destroy = {
    }
}
