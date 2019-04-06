<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
</head>
<body>

<navBar:localeDropdownListItems uri="${request.forwardURI}"/>

<div class="container vertical-center">
    <div class="login-form">
        <h2 class="text-center">
            <g:message code="ui.register_admin" />
        </h2>
        <br />
        <g:form url="/admin/register">
            <div class="form-group">
                <input type="text" name="email" placeholder="${g.message(code: 'ui.email')}" class="form-control" autocomplete="false">
            </div>
            <div class="form-group">
                <input type="password" name="password" placeholder="${g.message(code: 'ui.password')}" class="form-control" autocomplete="false">
            </div>
            <g:submitButton name="signin" value="${g.message(code: 'ui.register')}" class="btn btn-primary btn-block"></g:submitButton>

        %{--todo--}%
        %{--captcha--}%
        </g:form>

        <g:link url="/login">
            <button class="btn btn-primary btn-block" ><g:message code="ui.login"/></button>
        </g:link>
    </div>
</div>
</body>
</html>