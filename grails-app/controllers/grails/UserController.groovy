package grails

import grails.plugin.springsecurity.annotation.Secured
import user.User

class UserController {

    def index() { }

    @Secured("ROLE_USER")
    def users() {
        def usersList = User.list()
        [
                users: usersList
        ]
    }
}
