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
%{--todo logout--}%
%{--<form action="/logout" method="post">--}%
    %{--<input--}%
            %{--type="hidden"--}%
            %{--th:name="${_csrf.parameterName}"--}%
            %{--th:value="${_csrf.token}"--}%
    %{--/>--}%

    %{--<button type="submit" class="btn btn-primary btn-block logout" th:text="#{ui.logout}"></button>--}%
%{--</form>--}%

<h2 class="text-center" th:text="#{ui.add_new_product}"></h2>

<div class="container vertical-center">
    <div class="add-product-form">
        <div class="alert alert-danger validation-error" role="alert"><g:message message="${validationMessage}"/></div>

        <g:form controller="product" action="save">
            <div class="form-group">
                <input type="text" name="name" placeholder="${g.message(code: 'ui.name')}" class="form-control">
            </div>
            <div class="form-group">
                <input type="text" name="price" placeholder="${g.message(code: 'ui.price')}" class="form-control">
            </div>
            <div class="form-group">
                <input type="date" name="date" placeholder="${g.message(code: 'ui.date')}" class="form-control">
            </div>
            <g:submitButton name="saveProduct" value="${g.message(code: 'ui.add')}" class="btn btn-primary btn-block"></g:submitButton>
        </g:form>
    </div>
</div>
</body>
<script type="text/javascript">
    $( document ).ready(function() {
        var isSuccessful = [[${isSuccessful}]];

        if (isSuccessful !== null && !isSuccessful) {
            $('.validation-error').show();
        }
    });
</script>
</html>