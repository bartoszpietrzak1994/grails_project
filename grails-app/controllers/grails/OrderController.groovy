package grails

import grails.plugin.springsecurity.annotation.Secured
import order.Order
import order.OrderItem
import product.Product
import user.User

class OrderController
{
    @Secured("ROLE_ADMIN")
    def orders()
    {
        def orderList = Order.list()
        [
                orders: orderList
        ]
    }

    @Secured(["ROLE_USER", "ROLE_ADMIN"])
    def orderDetails()
    {
        def order = Order.findById(params.order.id)
        [
                order: order
        ]
    }

    @Secured("ROLE_USER")
    def place()
    {
        def product = Product.findByName(params.productName)
        def orderItem = new OrderItem(product: product)
        def order = new Order()

        orderItem.setOrder(order)
        order.setUser(User.findByUsername(params.userName))
        order.getOrderItems().add(orderItem)
        order.setNumber(UUID.randomUUID().toString())

        // todo pdf
    }
}
