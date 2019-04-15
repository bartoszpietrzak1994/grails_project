package grails

class UrlMappings {

    static mappings = {
        "/error" (controller: "error") {
            action = [ GET: 'error']
        }

        "/login" (controller: "user") {
            action = [ GET: 'loginView' ]
        }

        "/shop/register" (controller: "user") {
            action = [ GET: 'shopUserRegisterView', POST: 'shopUserRegister' ]
        }

        "/shop/index" (controller: "user") {
            action = [ GET: "shopUserIndex" ]
        }

        "/shop/orders/all" (controller: "order") {
            action = [ GET: "shopUserOrders"]
        }

        "/shop/products/all" (controller: "product") {
            action = [ GET: "shopProductsView"]
        }

        "/shop/orders/place" (controller: "order") {
            action = [ POST: "place"]
        }

        "/shop/orders/number/$number" (controller: "order") {
            action = [ GET: "shopUserOrderDetails" ]
        }

        "/admin/index" (controller: "user") {
            action = [ GET: "adminUserIndex" ]
        }

        "/admin/register" (controller: "user") {
            action = [ GET: 'adminUserRegisterView', POST: 'adminUserRegister' ]
        }

        "/admin/users/all" (controller: "user") {
            action = [ GET: "users" ]
        }

        "/admin/index" (controller: "user") {
            action = [ GET: "adminUserIndex" ]
        }

        "/admin/orders/all" (controller: "order") {
            action = [ GET: "adminUserOrders"]
        }

        "/admin/orders/number/$number" (controller: "order") {
            action = [ GET: "adminUserOrderDetails" ]
        }

        "/admin/products/add" (controller: "product") {
            action = [ GET: 'addProduct', POST: 'save' ]
        }

        "/admin/products/all" (controller: "product") {
            action = [ GET: 'adminProductsView' ]
        }

        "/registrationConfirm/$token" (controller: "user") {
            action = [ GET: "confirmRegistration" ]
        }

        "/" (uri: "/login")
        "500"(controller: 'error', action: 'error')
        "404"(controller: 'error', action: 'error')
    }
}
