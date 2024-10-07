<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>JSP Page</title> 
    </head>
    <body> 
        <h1>Validation Page</h1> 
        <jsp:useBean id="obj" scope="request" class="MyPackage.CheckerBeans"> 
            <jsp:setProperty name="obj" property="*"/> 
        </jsp:useBean> 
        <%if(obj.validate()) 
        {%> 
        <jsp:forward page="Successful.jsp"/> 
        <%} 
        else{%> 
        <jsp:include page="index.jsp"/> 
        <%}%> 
        <%=obj.getError()%> 
    </body> 
</html> 
