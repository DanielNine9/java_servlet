package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/home/trang-chu", "/home/gioi-thieu", "/home/lien-he" })
public class MenuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget");

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service1");

		String uri = req.getRequestURI();

		if (uri.contains("/home/trang-chu")) {
			req.setAttribute("view", "/home.jsp");
		} else if (uri.contains("/home/gioi-thieu")) {
			req.setAttribute("view", "/about.jsp");
		} else if (uri.contains("/home/lien-he")) {
			req.setAttribute("view", "/contact.jsp");
		}else {
			req.setAttribute("view", "/home.jsp");
		}
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
