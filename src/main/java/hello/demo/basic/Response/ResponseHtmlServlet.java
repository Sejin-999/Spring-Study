package hello.demo.basic.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name="responseHtmlRespose" , urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
       response.setCharacterEncoding("utf-8");
       PrintWriter writer = response.getWriter();
       writer.println("<html>");
       writer.println("<body>");
       writer.println("<div>안녕하세요</div>");
       writer.println("</body>");
       writer.println("</html>");

    }
}
