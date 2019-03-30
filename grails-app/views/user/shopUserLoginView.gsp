<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title text="${g.message(code: 'ui.signin')}"></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
</head>
<body>
    <div class="container vertical-center">
        <div class="login-form">
            <h2 class="text-center">
                <g:message code="ui.signin" />
            </h2>
            <br />
            <g:form url="/login">
                <div class="form-group">
                    <input type="text" name="email" placeholder="${g.message(code: 'ui.email')}" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" name="password" placeholder="${g.message(code: 'ui.password')}" class="form-control">
                </div>
                <g:submitButton name="signin" value="${g.message(code: 'ui.signin')}" class="btn btn-primary btn-block"></g:submitButton>
            </g:form>

            <g:link controller="user" action="shopUserRegisterView">
                <button class="btn btn-primary btn-block" ><g:message code="ui.register"/></button>
            </g:link>
        </div>
    </div>
</body>
</html>