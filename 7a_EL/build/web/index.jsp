<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          session.setAttribute("user","Admin");
        %>
        <%
          Cookie ck = new Cookie("name","mycookie");
          response.addCookie(ck);
        %>
        <form action="ExpressionLanguage.jsp">
            Enter name : <input type="text" name="name"><br>
            <input type="submit" value="submit">
        </form>
    </body>
</html>
