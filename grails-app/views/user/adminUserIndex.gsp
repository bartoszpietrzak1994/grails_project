<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
</head>
<body>

<g:form url="/logoff" method="POST">
    <button class="btn btn-primary btn-block logout"><g:message code="ui.logout" /></button>
</g:form>

<navBar:localeDropdownListItems uri="${request.forwardURI}"/>

<h2 class="text-center"><g:message code="ui.admin_index" /></h2>

<div class="container vertical-center">
    <div class="index-controls">
        <div class="text-center">
            <g:link url="/admin/users/all">
                <g:message code="ui.user_index" />
            </g:link>
        </div>
        <br />
        <div class="text-center">
            <g:link url="/admin/products/all">
                <g:message code="ui.available_events" />
            </g:link>
        </div>
        <div class="text-center">
            <g:link url="/admin/orders/all">
                <g:message code="ui.orders_index" />
            </g:link>
        </div>
        <div class="text-center">
            <g:link url="/admin/products/add">
                <g:message code="ui.add_new_product" />
            </g:link>
        </div>
    </div>
</div>
</body>
</html>