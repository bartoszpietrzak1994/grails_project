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

<h2 class="text-center"><g:message code="ui.orders_details" /></h2>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">
            <g:message code="ui.number" />
        </th>
        <th scope="col">
            <g:message code="ui.user" />
        </th>
        <th scope="col">
            <g:message code="ui.total" />
        </th>
        <th scope="col">
            <g:message code="ui.event" />
        </th>
        <th scope="col">
            <g:message code="ui.date" />
        </th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${order.number}</td>
        <td>${order.user.email}</td>
        <td>${total}</td>
        <td>${eventName}</td>
        <td>${eventDate}</td>
    </tr>
    </tbody>
</table>