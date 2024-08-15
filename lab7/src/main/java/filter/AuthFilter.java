package filter;


import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
@WebFilter(filterName = "AuthFilter", urlPatterns = {"*"})
public class AuthFilter implements HttpFilter {

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        String uri = req.getRequestURI();
        System.out.println("AuthFilter running");
        System.out.println("!uri.contains(\"login\") " + !uri.contains("login"));
        System.out.println("!uri.contains(\"register\") " + !uri.contains("register"));
        System.out.println("!uri.contains(\"logout\") " + !uri.contains("logout"));
        if(!uri.contains("login") && !uri.contains("register") && !uri.contains("logout")) {
        	 System.out.println(uri);
             User user = (User) req.getSession().getAttribute("user");
             String error = null;
             
             if (user == null) {
                 error = "Please login to use this function!";
             } else if (!user.getAdmin() && uri.contains("/user")) {
                 error = "Please login with admin role";
             }

             if (error != null) {
                 req.getSession().setAttribute("securi", error);
                 req.setAttribute("message", error);
                 req.setAttribute("view", "/login.jsp");
                 req.getRequestDispatcher("/index.jsp").forward(req, resp);
             } else {
            	 chain.doFilter(req, resp);
                 req.getSession().setMaxInactiveInterval(30); // Set to 30 minutes or a suitable value
             }
        }else {

            chain.doFilter(req, resp);
        }
    }
}

