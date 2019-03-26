package grails

import grails.plugin.springsecurity.annotation.Secured
import user.Registerer
import user.User
import user.VerificationTokenSender

class UserController
{
    Registerer registerer
    VerificationTokenSender verificationTokenSender

    @Secured("ROLE_ADMIN")
    def users()
    {
        def usersList = User.list()
        [
                users: usersList
        ]
    }

    def shopUserRegisterView()
    {
        render(template: "shopUserRegister")
    }

    def shopUserLoginView()
    {
        render(template: "shopUserLogin")
    }

    def shopUserRegister()
    {
        User user = this.registerer.register(params.user.email, params.user.password, "ROLE_USER", false)

        verificationTokenSender.generateAndSendTokenForUser(user)

        render(template: "shopUserRegister")
    }

    @Secured("ROLE_ADMIN")
    def adminUserRegisterView()
    {
        render(template: "adminUserRegister")
    }

    @Secured("ROLE_ADMIN")
    def adminUserRegister()
    {
        User user = this.registerer.register(params.user.email, params.user.password, "ROLE_ADMIN", true)

        render(template: "adminUserRegister")
    }
}
