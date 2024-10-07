import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAuth extends HttpServlet {
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null; 
    String n="",p="";
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int cnt=0;
        n=request.getParameter("txtuname");
        p=request.getParameter("txtpass");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","");
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from auth");
            while(rs.next())
            {
                String un=rs.getString(1);
                String up=rs.getString(2);
                if(n.equals(un) && p.equals(up))
                {
                    out.println("<h1>Welcome!!!"+un+"</h1>");
                    cnt++;
                    break;
                } 
            }
            if(cnt==0)
            {
                out.println("<h1>Sorry!!!Try again!!!</h1>");
            }
        }   
        catch(ClassNotFoundException | SQLException e)
        {
            out.println(e);
        }
    }
}
