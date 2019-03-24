package grails

import grails.plugin.springsecurity.annotation.Secured
import product.Product

class ProductController
{
    @Secured(["ROLE_USER", "ROLE_ADMIN"])
    def products()
    {
        def productList = Product.list()
        [
                products: productList
        ]
    }

    @Secured("ROLE_ADMIN")
    def addProduct()
    {
        render(template: 'addProduct')
    }

    @Secured("ROLE_ADMIN")
    def save()
    {
        def product = new Product(params)

        product.validate()

        if (product.hasErrors()) {
            render(view: 'addProduct', model: [product: product])

            return
        }

        product.save(flush: true)
        redirect(controller: 'product', action: 'products')
    }
}