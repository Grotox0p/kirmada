import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MainServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String n=request.getParameter("uname");
            String p=request.getParameter("upass");
            
            if(n.equals("admin")&&p.equals("Servlet"))
            {
                RequestDispatcher rd=request.getRequestDispatcher("SecondServlet");
                rd.forward(request,response);
            }
            else
            {
                out.print("Sorry username or password error");
                RequestDispatcher rd=request.getRequestDispatcher("/index.html");
                rd.include(request,response);
            }
            out.println("</body>");
            out.println("</html>");
            
        }
    }
}
