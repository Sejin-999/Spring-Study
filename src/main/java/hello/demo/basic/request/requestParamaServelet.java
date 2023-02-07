package hello.demo.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class requestParamaServelet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("전체파라미터 조회");
        req.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println("req = " + req.getParameter(paramName)));
        System.out.println("단일파라미터 조회");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);

        System.out.println("파라미터 이름이 같은경우");
        String [] usernames = req.getParameterValues("username");
        for(String name : usernames){
            System.out.println("username = " + name);
        }

    }
}
