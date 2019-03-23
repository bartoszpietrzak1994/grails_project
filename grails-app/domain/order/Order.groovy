package order

import user.User

class Order
{
    String number

    static hasOne = [user: User]
    static hasMany = [orderItems: OrderItem]

    static constraints = {
    }

    static mapping = {
        id(generator: 'org.hibernate.id.enhanced.SequenceStyleGenerator')
    }
}
