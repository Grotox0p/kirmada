import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class OneAnsDBServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
  ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    try {
      out.print("<html><body><br>");
      out.println("<form method='post' action='Marks'>");
      Class.forName("com.mysql.jdbc.Driver");
      Connection
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
      Statement st = con.createStatement();
      String sql = "select * from quiz";
      ResultSet rs = st.executeQuery(sql);
      int i = 0;
      out.print("<center>Online Exam</center>");
      while (rs.next()) {
        i++;
        out.print("<br><br><hr>" + rs.getInt(1) + " ");
        out.print(rs.getString(2));
        out.print("<br><input type=radio name=" + i + " value=1>" + rs.getString(3));
        out.print("<br><input type=radio name=" + i + " value=2>" + rs.getString(4));
        out.print("<br><input type=radio name=" + i + " value=3>" + rs.getString(5));
        out.print("<br><input type=radio name=" + i + " value=4>" + rs.getString(6));
        String ans = "ans" + i;
        out.println("<br><input type=hidden name=" + ans + " value=" + rs.getString(7) + ">");
      }
      out.println("<br><input type=hidden name=total value=" + i + ">");
      out.println("<input type=submit value=submit>");
      out.println("</form>");
      out.print("</body></html>");
    } catch (Exception e) {
      out.println("ERROR " + e.getMessage());
    }
  }
}