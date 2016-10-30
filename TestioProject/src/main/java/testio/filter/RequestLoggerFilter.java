package testio.filter;

import org.apache.log4j.Logger;
import org.hibernate.annotations.*;

import javax.servlet.*;

import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Mi on 27.10.16.
 */
//@WebFilter()
public class RequestLoggerFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(RequestLoggerFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("created RequestLoggerFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)){
            // nope
        } else {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;

            LOG.info(String.format("User %s, request %s",
                    req.getSession().getAttribute("currentUserName"),
                    req.getRequestURI()));
        }

        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }


}
