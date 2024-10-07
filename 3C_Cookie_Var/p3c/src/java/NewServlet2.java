import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServlet2 extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetCookie</title>");            
            out.println("</head>");
            out.println("<body>");
            Cookie ck[]=request.getCookies();
            out.print("Hello "+ck[0].getValue());
            out.close();
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
          System.out.print(e);
        }
    }
}
