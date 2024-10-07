import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con=null;
        PreparedStatement ps=null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String username=request.getParameter("uname");
        String password=request.getParameter("pw");
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","");
            out.println("Connection done succesfully...");
            ps=con.prepareStatement("insert into user1 values(?,?,?,?)");
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,country);
            ps.execute();
            out.println("Data inserted successfully");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(ClassNotFoundException | SQLException e)
        {
            out.println(e);
        }
    }
}
