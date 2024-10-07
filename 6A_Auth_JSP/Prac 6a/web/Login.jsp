<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%
          String uname = request.getParameter("txtName");
          String pass = request.getParameter("txtPass");
          
          try
          {
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select password from user where username = \" "+uname+"\" ");
            rs.next();
            if(pass.equals(rs.getString(1)))
            {
              out.println("<h1>~~~LOGIN SUCCESSFULL~~~</h1>");
            }
            else
            {
              out.println("<h1>password does not match !!!</h1>");
        %>
          <jsp:include page="Login.html"/>
          <%
           } 
           }catch(Exception e)
           {
             out.print("<h1>User does not exist !!!</h1>");
             out.print(e);
          %>
          <jsp:include page="index.html"/>
          <% 
           }
          %>
    </body>
</html>
