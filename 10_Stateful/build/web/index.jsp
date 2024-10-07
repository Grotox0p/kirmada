<%@page import="ejb.MarksEntryBean" %>
<%@page import="javax.naming.InitialContext" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    private static MarksEntryBean obj;
    public void jspInit()
    {
     try {
     InitialContext ic = new InitialContext();
     obj = (MarksEntryBean)ic.lookup("java:global/P10_a/MarksEntryBean");
     }
  catch(Exception e)
    { 
        System.out.println(e);
    }
}
%>

<%
    if(request.getParameter("InsertMarks")!=null)
    {
        String sname;
        int id,marks1, marks2, marks3;
        id=Integer.parseInt(request.getParameter("id"));
        sname = request.getParameter("sname");       
        marks1 = Integer.parseInt(request.getParameter("m1"));
        marks2 = Integer.parseInt(request.getParameter("m2"));
        marks3 = Integer.parseInt(request.getParameter("m3"));
        obj.addMarks(id,sname,marks1,marks2,marks3);
        out.println("Marks entered successfully..!!");
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enter Details</h1>
        <form name="result" method="post">
            Enter Student Id:<input type="text" name="id"/><br>
            Enter Student Name : <input type="text" name="sname" /><br/>
            Enter Subject 1 Marks : <input type="text" name="m1" /><br/>
            Enter Subject 2 Marks : <input type="text" name="m2" /><br/>
            Enter Subject 3 Marks : <input type="text" name="m3" /><br/>
            <input type="submit" name="InsertMarks" /><br/>
        </form>
    </body>
</html>

