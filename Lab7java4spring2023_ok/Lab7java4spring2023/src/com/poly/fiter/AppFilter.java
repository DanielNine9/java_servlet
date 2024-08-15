package com.poly.fiter;

import java.io.IOException;


import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.utils.RRSharer;
@WebFilter(filterName = "appFilter",urlPatterns = {"/*","/Bai3_LoginServlet"},dispatcherTypes = DispatcherType.REQUEST)
public class AppFilter implements HttpFilter{

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("app filter running");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		RRSharer.add(req, resp);
		chain.doFilter(req, resp);
		//RRSharer.remove(req, resp);
	}

}
