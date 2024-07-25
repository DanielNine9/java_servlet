package filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LangFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        String uri = req.getRequestURI();
        System.out.println("filter");
        HttpSession session = req.getSession();
        String pathInfo = req.getPathInfo();
        String lang = req.getParameter("lang");

        System.out.println("lang "+ lang);
        if (lang != null && lang.length() > 1) {
            session.setAttribute("lang", lang);
        } 
        
        System.out.println("session "+ session.getAttribute("lang"));
        chain.doFilter(req, res);
    }
}
