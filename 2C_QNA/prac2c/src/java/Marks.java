import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Marks extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            out.print("<html><body>");
            int total=Integer.parseInt(request.getParameter("total"));
            int marks=0;
            for(int i=1;i<=total;i++)
            {
              String sel= request.getParameter(Integer.toString(i));
              String ans=request.getParameter("ans"+i);
              if(sel.equals(ans))
              {
                marks++;
                
              }
            }
            out.println("Total Marks : "+marks);
            out.print("</body></html>");
        }
        catch(Exception e){}
        
    }
}
