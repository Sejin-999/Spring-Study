package hello.demo.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.demo.basic.JsonDaTA;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name ="requestJson", urlPatterns = "/request-json")
public class RequestJson extends HttpServlet {

    private ObjectMapper objMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        String msgbody =StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("msgbody = " + msgbody);

        JsonDaTA data;
        data = objMapper.readValue(msgbody,JsonDaTA.class);
        System.out.println("data.getUsername() = " + data.getUsername());
        System.out.println("data.getAge() = " + data.getAge());

        resp.getWriter().write("ok");
    }
}
