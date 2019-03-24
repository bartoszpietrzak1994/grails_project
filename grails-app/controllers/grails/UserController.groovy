package grails

import grails.plugin.springsecurity.annotation.Secured
import user.User

class UserController
{
    @Secured("ROLE_ADMIN")
    def users()
    {
        def usersList = User.list()
        [
                users: usersList
        ]
    }
}
