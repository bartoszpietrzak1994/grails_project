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

    def shopUserRegisterView() {}

    def shopUserLoginView() {}

    def shopUserRegister()
    {
        User user = this.registerer.register(params.email, params.password, "ROLE_USER", false)

        verificationTokenSender.generateAndSendTokenForUser(user)

        redirect(controllerName: user, actionName: shopUserRegisterView)
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
