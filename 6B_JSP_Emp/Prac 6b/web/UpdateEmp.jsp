<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Employee Record Update</h1>
        <%
          String eid = request.getParameter("txtEid");
          String name = request.getParameter("txtEname");
          String age = request.getParameter("txtAge");
          String sal = request.getParameter("txtSal");
          try
          {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","");
            PreparedStatement pstmt = con.prepareStatement("select * from emp where empid=?");
            pstmt.setString(1,eid);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
              out.print("<h1>~~~~~~~~Employee " + name + "Exist~~~~~~~</h1>");
              PreparedStatement pst1 = con.prepareStatement("Update emp set salary=? where empid=?");
              PreparedStatement pst2 = con.prepareStatement("Update emp set age=? where empid=?");
              PreparedStatement pst3 = con.prepareStatement("Update emp set ename=? where empid=?");
              pst1.setString(1,sal);
              pst1.setString(2,eid);
              pst2.setString(1,age);
              pst2.setString(2,eid);
              pst3.setString(1,name);
              pst3.setString(2,eid);
              pst1.executeUpdate();
              pst2.executeUpdate();
              pst3.executeUpdate();
            }
            else
            {
              out.print("<h1>Employee record does not exist!!!</h1>");
            }
          }
          catch(Exception e)
          {
            out.print(e);
          }
        %>
    </body>
</html>
