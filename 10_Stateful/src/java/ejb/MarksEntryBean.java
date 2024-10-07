package ejb;
import java.sql.*;
import javax.ejb.Stateful;
@Stateful
public class MarksEntryBean {
    Connection con = null;
    Statement st = null;
    String query = "";
    public void addMarks(int id,String sname, int m1, int m2, int m3)
    {
        try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksdb","root",""); 
             st = con.createStatement();
             query = "insert into marks(id,sname,marks1,marks2,marks3) values ('"+id+"','"+sname+"','"+m1+"','"+m2+"','"+m3+"')";
             st.executeUpdate(query);
        }    
        catch(Exception e){ System.out.println(e); }
    }
}
