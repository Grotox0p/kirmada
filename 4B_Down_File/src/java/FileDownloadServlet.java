
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;

public class FileDownloadServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("APPLICATION/OCTET-STREAM");
        String filename = request.getParameter("filename");
        ServletContext context = getServletContext();
        InputStream is = context.getResourceAsStream("/" + filename);
        ServletOutputStream os = response.getOutputStream();
        response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");
        int i;
        byte b[]=new byte[1024];
        while ((i=is.read(b)) != -1)
        {
            os.write(b);
        }
        is.close();
        os.close();
    }
}
