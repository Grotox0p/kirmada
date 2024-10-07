import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpSessionServlet extends HttpServlet {
    private int counter=0;
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HttpSessionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            HttpSession session =request.getSession(true);
        if(session.isNew())
            {
              out.print("This is the first time you are visiting this page");
              ++counter;
            }
            else
            {
              synchronized(HttpSessionServlet.this)
              {
                if(counter==10)
                {
                  session.invalidate();
                  counter=0;
                  request.getSession(false);
                }
                else
                {
                  out.print("You have visited this page "+(++counter)+" times");
                }
              }
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
}
