package HTTPWebServer;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "example",
        urlPatterns = "/ecomanda/example"
)

public class ExampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        ServletOutputStream out = response.getOutputStream();
        out.write("Hello".getBytes());
        out.flush();
        out.close();
    }
}
