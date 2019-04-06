package grails


import product.Product

class ProductController
{
//    @Secured("ROLE_ADMIN")
    def adminProductsView()
    {
        def productList = Product.list()
        [
                products: productList
        ]
    }

//    @Secured("ROLE_USER")
    def shopProductsView()
    {
        def productList = Product.list()
        [
                products: productList
        ]
    }

//    @Secured("ROLE_ADMIN")
    def addProduct() {}

//    @Secured("ROLE_ADMIN")
    def save()
    {
        def product = new Product(params)

        product.validate()

        if (product.hasErrors()) {
            render(view: 'addProduct', model: [product: product])
        }
        else {
            product.save(flush: true, failOnError: true)
            redirect(uri: '/admin/products/all')
        }
    }
}
