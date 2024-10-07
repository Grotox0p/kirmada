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
          String pass1 = request.getParameter("txtPass1");
          String pass2 = request.getParameter("txtPass2");
          String email = request.getParameter("txtEmail");
          String ctry = request.getParameter("txtCon");
          if(pass1.equals(pass2))
          {
            try
            {
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","");
              PreparedStatement stmt = con.prepareStatement("insert into user values(?,?,?,?);");
              stmt.setString(1,uname);
              stmt.setString(2,pass1);
              stmt.setString(3,email);
              stmt.setString(4,ctry);
              int row = stmt.executeUpdate();
              if(row==1)
              {
                out.println("Registration Successfull");
              }
              else
              {
                out.print("Registration FAILED !!!");
              %>
              <jsp:include page="index.html"/>      
        <%}
          }catch(Exception e)
           {
             out.println(e);
           }
          }
          else
          {
            out.println("<h1>Password Mismatch</h1>");
        %>
        <jsp:include page="Registration.html"/>
        <%}
        %>
    </body>
</html>
