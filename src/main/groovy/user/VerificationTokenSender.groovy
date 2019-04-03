package user

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender

class VerificationTokenSender
{
    private static final String REGISTRATION_CONFIRMATION_URL = "http://localhost:8080/registrationConfirm/"
    private JavaMailSender mailSender

    void generateAndSendTokenForUser(User user)
    {
        String token = UUID.randomUUID()

        def verificationToken = new VerificationToken(user, token)
        verificationToken.save(flush: true, failOnError: true)

        String recipientAddress = user.getEmail()
        String subject = "Registration Confirmation"
        String confirmationUrl = REGISTRATION_CONFIRMATION_URL + token

        SimpleMailMessage email = new SimpleMailMessage()
        email.setTo(recipientAddress)
        email.setSubject(subject)
        email.setText(confirmationUrl)
        mailSender.send(email)
    }

    void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender
    }
}
