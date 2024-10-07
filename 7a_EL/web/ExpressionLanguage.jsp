<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Welcome, ${param.name}<br>
        <b>Session value is :</b> ${sessionScope.user}<br>
        <b>Cookie name is :</b> ${cookie.name.value}<br>
    </body>
</html>
