package grails

import user.User

class UserController {

    def index() { }

    def users() {
        def usersList = User.list()
        [
                users: usersList
        ]
    }
}
