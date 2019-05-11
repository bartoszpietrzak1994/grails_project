package grails

import grails.plugin.springsecurity.annotation.Secured
import recaptcha.ReCaptchaChecker
import user.*

class UserController
{
    Registerer registerer
    ReCaptchaChecker reCaptchaChecker
    VerificationTokenSender verificationTokenSender

    @Secured("ROLE_ADMIN")
    def users()
    {
        def usersList = User.list()
        [
                users: usersList
        ]
    }

    @Secured("permitAll")
    def loginView() {}

    @Secured("permitAll")
    def shopUserRegisterView() {}

    @Secured("permitAll")
    def adminUserRegisterView() {}

    @Secured("permitAll")
    def shopUserRegister()
    {
        if (!this.reCaptchaChecker.verifyResponse((String) params.get("g-recaptcha-response"))) {
            redirect(uri: "/shop/register")

            return
        }

        User user = this.registerer.register(params.email, params.password, "ROLE_USER", false)

        verificationTokenSender.generateAndSendTokenForUser(user)

        redirect(uri: "/shop/index")
    }

    @Secured("permitAll")
    def confirmRegistration()
    {
        VerificationToken verificationToken = VerificationToken.findByToken(params.token)

        if (verificationToken == null) {
            redirect(controllerUri: '/error')

            return
        }

        Calendar cal = Calendar.getInstance()
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            redirect(controllerUri: '/error')

            return
        }

        User user = verificationToken.getUser()

        user.setEnabled(true)

        user.save(flush: true, failOnError: true)

        redirect(uri: "/login")
    }

    @Secured("permitAll")
    def adminUserRegister()
    {
        if (!this.reCaptchaChecker.verifyResponse((String) params.get("g-recaptcha-response"))) {
            redirect(uri: "/admin/register")

            return
        }

        User user = this.registerer.register(params.email, params.password, "ROLE_ADMIN", true)

        redirect(controllerName: user, actionName: users())
    }

    @Secured("ROLE_USER")
    def shopUserIndex() {}

    @Secured("ROLE_ADMIN")
    def adminUserIndex() {}
}
