package spring

import grails.plugin.springsecurity.SpringSecurityUtils
import order.PdfFileSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import user.CurrentUserProvider
import user.Registerer
import user.TicketAppAuthenticationSuccessHandler
import user.UserPasswordEncoderListener
import user.VerificationTokenSender

beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    registerer(Registerer) {
        bCryptPasswordEncoder = ref('bCryptPasswordEncoder')
    }
    mailSender(JavaMailSenderImpl) {
        protocol = 'smtp'
        host = 'smtp.gmail.com'
        port = 587
        username = 'ticketappspring'
        password = 'onggtnmhgbobmlyk'

        Properties mailProps = new Properties()
        mailProps.put("mail.smtps.auth", "true")
        mailProps.put("mail.smtp.starttls.enable", "true")
        mailProps.put("mail.smtp.debug", "true")

        javaMailProperties = mailProps
    }
    verificationTokenSender(VerificationTokenSender) {
        mailSender = ref('mailSender')
    }
    bCryptPasswordEncoder(BCryptPasswordEncoder)
    currentUserProvider(CurrentUserProvider)
    pdfFileSender(PdfFileSender) {
        mailSender = ref('mailSender')
    }
    authenticationSuccessHandler(TicketAppAuthenticationSuccessHandler) {
        def conf = SpringSecurityUtils.securityConfig
        /* Configuring the bean */
        defaultTargetUrl = conf.successHandler.defaultTargetUrl
        alwaysUseDefaultTargetUrl = conf.successHandler.alwaysUseDefault
        targetUrlParameter = conf.successHandler.targetUrlParameter
        useReferer = conf.successHandler.useReferer
    }
}
