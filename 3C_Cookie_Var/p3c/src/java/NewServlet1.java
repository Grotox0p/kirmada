import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServlet1 extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddCookieServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String n=request.getParameter("userName");
            out.print("Welcome " + n);
            Cookie ck=new Cookie("uname",n);
            response.addCookie(ck);
            out.print("<form action=NewServlet2>");
            out.print("<input type='submit' value='go'>");
            out.print("</form>");
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
