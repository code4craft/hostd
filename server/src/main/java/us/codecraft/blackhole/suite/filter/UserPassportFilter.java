package us.codecraft.blackhole.suite.filter;

import us.codecraft.blackhole.suite.model.UserPassport;
import us.codecraft.blackhole.suite.service.UserPassportSerivce;
import us.codecraft.blackhole.suite.util.SpringLocator;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * User: cairne
 * Date: 13-5-14
 * Time: 下午1:54
 */
public class UserPassportFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        UserPassportSerivce userPassportSerivce = SpringLocator.getBean(UserPassportSerivce.class);
        UserPassport userPassport = userPassportSerivce.getUserPassport((HttpServletRequest) request);
        request.setAttribute("userPassport", userPassport);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
    }

}
