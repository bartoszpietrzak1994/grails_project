package user

import java.sql.Timestamp

class VerificationToken
{
    private String token
    private Date expiryDate
    private User user

    static constraints = {
    }

    static mapping = {
        id(generator: 'org.hibernate.id.enhanced.SequenceStyleGenerator')
    }

    VerificationToken()
    {
        this.expiryDate = calculateExpiryDate()
    }

    User getUser()
    {
        return user
    }

    String getToken()
    {
        return token
    }

    Date getExpiryDate()
    {
        return expiryDate
    }

    void setToken(String token) {
        this.token = token
    }

    void setUser(User user) {
        this.user = user
    }

    private static Date calculateExpiryDate()
    {
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(new Timestamp(calendar.getTime().getTime()))
        calendar.add(Calendar.MINUTE, 1440)
        return new Date(calendar.getTime().getTime())
    }
}
