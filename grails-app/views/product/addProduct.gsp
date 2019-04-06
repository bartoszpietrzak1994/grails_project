<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title th:text="#{ui.add_new_product}"></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<g:form url="/logout" method="post">
    <button type="submit" class="btn btn-primary btn-block logout"><g:message code="ui.logout" /></button>
</g:form>

<navBar:localeDropdownListItems uri="${request.forwardURI}"/>

<h2 class="text-center" th:text="#{ui.add_new_product}"></h2>

<div class="container vertical-center">
    <div class="add-product-form">
        <g:form url="/admin/products/add" method="post">
            <div class="form-group">
                <label><g:message code="ui.name" /></label>
                <g:renderErrors bean="${product}" as="list" field="name" />
                <g:textField name="name" class="form-control" autocomplete="off" />
            </div>
            <div class="form-group">
                <label><g:message code="ui.price" /></label>
                <g:renderErrors bean="${product}" as="list" field="price" />
                <g:textField name="price" class="form-control" autocomplete="off" />
            </div>
            <div class="form-group">
                <label><g:message code="ui.date" /></label>
                <br />
                <g:renderErrors bean="${product}" as="list" field="date"/>
                <g:datePicker name="date" precision="day" class="form-control" />
            </div>
            <g:submitButton name="saveProduct" value="${g.message(code: 'ui.add')}" class="btn btn-primary btn-block"></g:submitButton>
        </g:form>
    </div>
</div>
</body>
</html>