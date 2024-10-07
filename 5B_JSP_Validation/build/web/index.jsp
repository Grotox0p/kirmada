<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>JSP Page-User Interface</title> 
    </head> 
    <body> 
        <form action="Validate.jsp"> 
            Enter your name: <input type="text" name="name"><br> 
            Enter your age: <input type="text" name="age"><br> 
            Enter your hobbies <br> <input type="checkbox" name="hob" 
            value="Singing">Singing<br> 
            <input type="checkbox" name="hob" value="Reading">Reading<br> 
            <input type="checkbox" name="hob" value="Reading">Playing Football<br> 
            Enter E-mail ID: <input type="text" name="email"><br> 
            Select Gender <br><input type="radio" name="gender" value="female">Female<br> 
            <input type="radio" name="gender" value="male">Male<br> 
            <input type="radio" name="gender" value="other">Other<br> 
            <input type="hidden" name="error" value=""> 
            <input type="submit" value="Submit Form"> 
        </form> 
    </body> 
</html>
