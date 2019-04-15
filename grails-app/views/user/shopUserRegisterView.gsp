<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
    <script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>

<navBar:localeDropdownListItems uri="${request.forwardURI}"/>

<div class="container vertical-center">
    <div class="login-form">
        <h2 class="text-center">
            <g:message code="ui.register_user" />
        </h2>
        <br />
        <g:form url="/shop/register">
            <div class="form-group">
                <input type="text" name="email" placeholder="${g.message(code: 'ui.email')}" class="form-control" autocomplete="off">
            </div>
            <div class="form-group">
                <input type="password" name="password" placeholder="${g.message(code: 'ui.password')}" class="form-control" autocomplete="off">
            </div>

            <div class="form-group">
                <div class="g-recaptcha" data-sitekey="6LeslJwUAAAAADZ_LuRjLY6rZRjyhVjGsjV-C0ey"></div>
            </div>

            <g:submitButton name="signin" value="${g.message(code: 'ui.register')}" class="btn btn-primary btn-block"></g:submitButton>
        </g:form>

        <g:link url="/admin/register">
            <button class="btn btn-primary btn-block" ><g:message code="ui.admin_register"/></button>
        </g:link>

        <g:link url="/login">
            <button class="btn btn-primary btn-block" ><g:message code="ui.login"/></button>
        </g:link>
    </div>
</div>
</body>
</html>