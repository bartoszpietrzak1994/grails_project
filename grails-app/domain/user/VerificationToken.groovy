package user

import java.sql.Timestamp

class VerificationToken
{
    private String token
    private Date expiryDate

    static belongsTo = [user:User]

    static constraints = {
    }

    static mapping = {
        id(generator: 'org.hibernate.id.enhanced.SequenceStyleGenerator')
    }

    VerificationToken(){}

    VerificationToken(User user, String token)
    {
        this.user = user
        this.token = token
        this.expiryDate = calculateExpiryDate()
    }

    private static Date calculateExpiryDate()
    {
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(new Timestamp(calendar.getTime().getTime()))
        calendar.add(Calendar.MINUTE, 1440)
        return new Date(calendar.getTime().getTime())
    }
}
