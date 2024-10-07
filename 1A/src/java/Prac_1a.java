import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Prac_1a extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Prac_1a</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome "+ request.getParameter("txtName")+"</h1>");
            out.println("<br><a href='index.html'>Click here to go back</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
