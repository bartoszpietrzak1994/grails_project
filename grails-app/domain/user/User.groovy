package user

import order.Order

class User
{
    String email
    String password
    boolean enabled

    static hasMany = [userRoles: UserRole, orders: Order]

    static constraints = {
        password nullable: false, blank: false
        email nullable: false, blank: false, unique: true
        enabled nullable: false
    }

    static mapping = {
        id(generator: 'org.hibernate.id.enhanced.SequenceStyleGenerator')
    }
}
