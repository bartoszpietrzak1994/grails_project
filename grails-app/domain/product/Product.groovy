package product

import order.OrderItem

class Product
{
    String name
    double price
    Date date

    static belongsTo = [orderItem: OrderItem]

    static constraints = {
        name unique: true
    }

    static mapping = {
        id(generator: 'org.hibernate.id.enhanced.SequenceStyleGenerator')
    }
}
