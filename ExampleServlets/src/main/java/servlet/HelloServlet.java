package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userNameParameter = req.getParameter("name");
        String queryString = req.getQueryString();

        System.out.printf("client %s, name %s, query %s\n", req.getRemoteUser(), userNameParameter, queryString);

        Cookie[] cookies = req.getCookies();

        if(cookies != null){
            Arrays.stream(cookies).forEach((cookie -> {
                System.out.printf("name %s, value %s\n", cookie.getName(), cookie.getValue());
            }));
        }

        PrintWriter pw = resp.getWriter();
        pw.printf("<h1>Hello %s</h1>", userNameParameter);
        pw.flush();
    }
}
