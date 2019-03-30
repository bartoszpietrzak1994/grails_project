<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of users</title>
</head>
<body>
<g:each in="${users}" var="user" status="i">
    <h3>${i+1}. ${user.username}</h3>
    <h3>${i+1}. ${user.enabled}</h3>
    <br/>
</g:each>

<g:recaptchaLogin/>
</body>
</html>