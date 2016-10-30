package testio.test.testAjax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

/**
 * Created by Mi on 30.10.2016.
 */
@WebServlet(urlPatterns = {"/ajax/hello"})
public class AjaxSimpleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        String responseMessage = "Hello " + name + ", Server Time" + LocalTime.now().toString();

        resp.getWriter().print(responseMessage);
    }
}
