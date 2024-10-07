import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class CookieServlet extends HttpServlet {
    private int i=1;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookieServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String k=String.valueOf(i);
            Cookie c=new Cookie("visit",k);
            response.addCookie(c);
            int j=Integer.parseInt(c.getValue());
            if(j==1)
            {
              out.println("This is the first time you are visiting this page");
            }
            else
            {
              synchronized(CookieServlet.this)
              {
                out.println("You visited this page " + i + " times");
              }
            }
           i++;
            out.println("</body>");
            out.println("</html>");
        }
    }
}
