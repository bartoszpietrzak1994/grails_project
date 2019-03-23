package order

import product.Product

class OrderItem
{
    static hasOne = [product: Product]
    static belongsTo = [order: Order]

    static constraints = {
    }

    static mapping = {
        id(generator: 'org.hibernate.id.enhanced.SequenceStyleGenerator')
    }
}
