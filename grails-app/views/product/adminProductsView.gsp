<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title th:text="#{ui.products_index}"></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
</head>
<body>
<g:form url="/logout" method="post">
    <button type="submit" class="btn btn-primary btn-block logout"><g:message code="ui.logout" /></button>
</g:form>

<navBar:localeDropdownListItems uri="${request.forwardURI}"/>

<h2 class="text-center"><g:message code="ui.products_index" /></h2>

<div class="container vertical-center">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col"></th>
            <th scope="col"><g:message code="ui.name"/></th>
            <th scope="col"><g:message code="ui.price"/></th>
            <th scope="col"><g:message code="ui.date"/></th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${products}" var="product" status="i">
            <td>${i+1}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.date}</td>
        </g:each>
        </tbody>
    </table>
</div>
</body>
</html>