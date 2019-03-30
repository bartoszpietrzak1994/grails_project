package grails

import grails.plugin.springsecurity.annotation.Secured
import user.Registerer
import user.User
import user.VerificationToken
import user.VerificationTokenSender

class UserController
{
    Registerer registerer
    VerificationTokenSender verificationTokenSender

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

        redirect(controllerName: user, actionName: users())
    }

    def confirmRegistration()
    {
        VerificationToken verificationToken = VerificationToken.findByToken(params.token)

        if (verificationToken == null) {
            redirect(controllerUri: '/error')
        }

        Calendar cal = Calendar.getInstance()
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            redirect(controllerUri: '/error')
        }

        User user = verificationToken.getUser()

        user.setEnabled(true)

        user.save(flush: true, failOnError: true)
    }

    @Secured("ROLE_ADMIN")
    def adminUserRegisterView()
    {

    }

    @Secured("ROLE_ADMIN")
    def adminUserRegister()
    {
        User user = this.registerer.register(params.user.email, params.user.password, "ROLE_ADMIN", true)

        redirect(controllerName: user, actionName: users())
    }
}
