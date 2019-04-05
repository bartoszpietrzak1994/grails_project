package order

import product.Product

class OrderItem
{
    Product product

    static belongsTo = [order: Order]

    static constraints = {
    }

    static mapping = {
        id(generator: 'org.hibernate.id.enhanced.SequenceStyleGenerator')
    }

    Product getProduct() {
        return product
    }

    void setProduct(Product product) {
        this.product = product
    }
}
