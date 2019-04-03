package grails

import grails.plugin.springsecurity.annotation.Secured
import order.Order
import order.OrderItem
import order.PdfFileSender
import product.Product
import user.CurrentUserProvider
import user.User

class OrderController
{
    CurrentUserProvider currentUserProvider
    PdfFileSender pdfFileSender

//    @Secured("ROLE_ADMIN")
    def orders()
    {
        def orderList = Order.list()
        [
                orders: orderList
        ]
    }

//    @Secured(["ROLE_USER", "ROLE_ADMIN"])
    def orderDetails()
    {
        def order = Order.findById(params.order.id)
        [
                order: order
        ]
    }

//    @Secured("ROLE_USER")
    def place()
    {
        def product = Product.findByName(params.productName)
        def orderItem = new OrderItem(product: product)
        def order = new Order()

        orderItem.setOrder(order)

        def userEmail = currentUserProvider.getCurrentlyLoggedUsersEmail()
        order.setUser(User.findByEmail(userEmail))
        order.getOrderItems().add(orderItem)
        order.setNumber(UUID.randomUUID().toString())

        pdfFileSender.sendPdfFile(userEmail, order)
    }

//    @Secured(["ROLE_USER", "ROLE_ADMIN"])
    def usersOrders()
    {
        def userEmail = currentUserProvider.getCurrentlyLoggedUsersEmail()
        def user = User.findByEmail(userEmail)

        def orders = Order.findAllByUser(user)
        [
                orders: orders
        ]
    }
}
