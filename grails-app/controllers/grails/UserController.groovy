package grails


import grails.plugin.springsecurity.annotation.Secured
import user.*

class UserController
{
    Registerer registerer
    VerificationTokenSender verificationTokenSender
    CurrentUserProvider currentUserProvider

//    @Secured("ROLE_ADMIN")
    def users()
    {
        def usersList = User.list()
        [
                users: usersList
        ]
    }

//    @Secured("permitAll")
    def loginView() {}

//    @Secured("permitAll")
    def shopUserRegisterView() {}

//    @Secured("permitAll")
    def shopUserRegister()
    {
        User user = this.registerer.register(params.email, params.password, "ROLE_USER", false)

        verificationTokenSender.generateAndSendTokenForUser(user)

        redirect(controllerName: user, actionName: shopUserIndex())
    }

//    @Secured("permitAll")
    def confirmRegistration(String token)
    {
        VerificationToken verificationToken = VerificationToken.findByToken(token)

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

        redirect(controllerName: user, actionName: shopUserLoginView())
    }

//    @Secured("permitAll")
    def adminUserRegister()
    {
        User user = this.registerer.register(params.user.email, params.user.password, "ROLE_ADMIN", true)

        redirect(controllerName: user, actionName: users())
    }

//    @Secured("ROLE_USER")
    def shopUserIndex() {}

//    @Secured("ROLE_ADMIN")
    def adminUserIndex() {}
}
