package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import mybeans.CCBean;

@WebServlet(name = "CCServlet", urlPatterns = {"/CCServlet"})
public class CCServlet extends HttpServlet {
    
    @EJB CCBean obj;
    @Override
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          double amt=Double.parseDouble(request.getParameter("amt"));
          if(request.getParameter("type").equals("r2d"))
          {
              out.println("<h1>"+amt+"Rupees = "+obj.r2Dollars(amt)+" Dollars</h1>");
          }
          if(request.getParameter("type").equals("d2r"))
          {
              out.println("<h1>"+amt+"Dollars = "+obj.d2Rupees(amt)+" Rupees</h1>");
          }
        }
    }
}

