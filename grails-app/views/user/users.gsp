<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List o books</title>
</head>
<body>
<g:each in="${users}" var="user" status="i">
    <h3>${i+1}. ${user.username}</h3>
</g:each>
</body>
</html>