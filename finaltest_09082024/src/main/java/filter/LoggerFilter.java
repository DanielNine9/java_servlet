package filter;


import java.io.IOException;

import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;

@WebFilter(filterName = "LoginFilter", urlPatterns = {("/accountBai3/sign-in")})
public class LoggerFilter implements HttpFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("HttpFilter running");
		User user = (User) req.getSession().getAttribute("user");
		String uri = req.getRequestURI();
		Date time = new Date();
		//code
		chain.doFilter(req, resp);
	}

}
