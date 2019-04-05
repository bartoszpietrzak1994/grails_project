package order

import user.User

class Order
{
    String number
    User user

    static hasOne = [orderItem: OrderItem]

    static constraints = {
    }

    static mapping = {
        id(generator: 'org.hibernate.id.enhanced.SequenceStyleGenerator')
        table "orders"
    }
}
