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

    @Secured("ROLE_USER")
    def shopUserOrders()
    {
        def orderList = Order.list()
        [
                orders: orderList
        ]
    }

    @Secured("ROLE_ADMIN")
    def adminUserOrders()
    {
        def orderList = Order.list()
        [
                orders: orderList
        ]
    }

    @Secured(["ROLE_USER", "ROLE_ADMIN"])
    def shopUserOrderDetails()
    {
        def order = Order.findByNumber(params.number)
        def orderItem = OrderItem.findByOrder(order)
        [
                order: order,
                total: orderItem.getProduct().getPrice(),
                eventName: orderItem.getProduct().getName(),
                eventDate: orderItem.getProduct().getDate().format("yyyy-MM-dd")
        ]
    }

    @Secured("ROLE_ADMIN")
    def adminUserOrderDetails()
    {
        def order = Order.findByNumber(params.number)
        def orderItem = OrderItem.findByOrder(order)
        [
                order: order,
                total: orderItem.getProduct().getPrice(),
                eventName: orderItem.getProduct().getName(),
                eventDate: orderItem.getProduct().getDate().format("yyyy-MM-dd")
        ]
    }

    @Secured("ROLE_USER")
    def place()
    {
        def product = Product.findByName(params.productName)
        def orderItem = new OrderItem(product: product)
        def userEmail = currentUserProvider.getCurrentlyLoggedUsersEmail()

        def order = new Order()
        orderItem.setOrder(order)
        orderItem.setProduct(product)
        order.setOrderItem(orderItem)
        order.setUser(User.findByEmail(userEmail))
        order.setNumber(UUID.randomUUID().toString())

        order.save(flush: true, failOnError: true)

        pdfFileSender.sendPdfFile(userEmail, order)

        redirect(uri: '/shop/orders/all')
    }

    @Secured(["ROLE_USER", "ROLE_ADMIN"])
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
