package order

import product.Product

class OrderItemProduct implements Serializable
{
    OrderItem orderItem
    Product product

    static constraints = {
        orderItem nullable: false
        product nullable: false
    }

    static mapping = {
        id composite: ['orderItem', 'product']
        version false
    }
}
