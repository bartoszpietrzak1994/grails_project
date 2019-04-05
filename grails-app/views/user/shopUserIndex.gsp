<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
</head>
<body>

<g:form url="/logout" method="post">
    <button type="submit" class="btn btn-primary btn-block logout"><g:message code="ui.logout" /></button>
</g:form>

<navBar:localeDropdownListItems uri="${request.forwardURI}"/>

<h2 class="text-center"><g:message code="ui.user_index" /></h2>

<div class="container vertical-center">
    <div class="index-controls">
        <div class="text-center">
            <g:link url="/shop/orders/all">
                <g:message code="ui.my_orders" />
            </g:link>
        </div>
        <br />
        <div class="text-center">
            <g:link url="/shop/products/all">
                <g:message code="ui.available_events" />
            </g:link>
        </div>
    </div>
</div>
</body>
</html>