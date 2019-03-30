package spring

import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import user.Registerer
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
}
