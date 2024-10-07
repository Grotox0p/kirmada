
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String uname=request.getParameter("txtid");
            String upass=request.getParameter("txtpass");
            if(uname.equals("admin")&& upass.equals("1234"))
            {
                out.println("<body bgcolor=pink>");
                out.println("<h1>Welcome!!!"+uname+"</h1>");
            }
            else
            {
                out.println("<body bgcolor=cyan>");
                out.println("<h1> Login Fail!!!");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

  
}
