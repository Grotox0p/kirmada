package mypack;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mybean.Operations;

@WebServlet(name = "CalServlet", urlPatterns = {"/CalServlet"})
public class CalServlet extends HttpServlet {
    @EJB Operations obj;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            int a = Integer.parseInt(request.getParameter("n1"));
            int b = Integer.parseInt(request.getParameter("n2"));
            if(request.getParameter("type").equals("add")) {
                out.println("<h1> Addition: </h1>");
                out.println("<h1>"+a+"+"+b+" = "+obj.add(a,b)+"</h1>");
            }
            if(request.getParameter("type").equals("sub")){
                out.println("<h1> Subtraction: </h1>");
                out.println("<h1>"+a+"-"+b+" = "+obj.sub(a,b)+"</h1>");
            }
            if(request.getParameter("type").equals("mul")) {
                out.println("<h1> Multiplication: </h1>");
                out.println("<h1>"+a+"*"+b+" = "+obj.mul(a,b)+"</h1>");
            }
            if(request.getParameter("type").equals("div")){
                out.println("<h1> Division: </h1>");
                out.println("<h1>"+a+"/"+b+" = "+obj.div(a,b)+"</h1>");
            }
            if(request.getParameter("type").equals("mod")){
                out.println("<h1> Modulo: </h1>");
                out.println("<h1>"+a+"%"+b+" = "+obj.mod(a,b)+"</h1>");
            }
        }
    }
}
