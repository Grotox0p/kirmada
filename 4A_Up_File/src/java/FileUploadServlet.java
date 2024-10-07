import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,
    IOException
    {
     res.setContentType("text/html");
     PrintWriter out = res.getWriter();
     String path=req.getParameter("destination");
     Part filePart=req.getPart("file");
     String filename=filePart.getSubmittedFileName().toString();
     out.print("<br><br><hr> file name: "+filename);
     OutputStream os=null;
     InputStream is=null;
     try
     {
        os=new FileOutputStream(new File(path+File.separator+filename));
        is=filePart.getInputStream();

        int read=0;
        byte[] b=new byte[1024];
        while ((read = is.read(b)) != -1)
        {
            os.write(b, 0, read);
        }
        out.println("<br>file uploaded sucessfully...!!!");
    }
    catch(FileNotFoundException e)
    {
        out.print(e);
    }
}
}
