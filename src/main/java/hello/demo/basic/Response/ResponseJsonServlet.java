package hello.demo.basic.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.demo.basic.JsonDaTA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet" , urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        JsonDaTA jsondata = new JsonDaTA();
        jsondata.setUsername("양");
        jsondata.setAge(25);

        String result = objectMapper.writeValueAsString(jsondata);
        response.getWriter().write(result);
    }
}
