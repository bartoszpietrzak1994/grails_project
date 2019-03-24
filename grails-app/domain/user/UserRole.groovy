package user

class UserRole
{
    String roleName

    static constraints = {
        roleName unique: true
    }

    static mapping = {
        id(generator: 'org.hibernate.id.enhanced.SequenceStyleGenerator')
    }
}
