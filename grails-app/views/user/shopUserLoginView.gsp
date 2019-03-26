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
            <h2 class="text-center" text="${g.message(code: 'ui.signin')}"></h2>
            <br />
            <form action="/shop/login" method="post">
                <div class="form-group">
                    <input type="text" name="email" placeholder="${g.message(code: 'ui.email')}" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" name="password" placeholder="${g.message(code: 'ui.password')}" class="form-control">
                </div>
                <button class="btn btn-primary btn-block" type="submit" text="${g.message(code: 'ui.signin')}"></button>

                %{--todo--}%
                %{--captcha--}%
            </form>

            <p class="text-center">
                <a href="/shop/register" text="${g.message(code: 'ui.register')}"></a>
            </p>
        </div>
    </div>
</body>
</html>