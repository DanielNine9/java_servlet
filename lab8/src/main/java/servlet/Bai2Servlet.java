package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/bai2/home", "/bai2/login", "/bai2/logout", "/bai2/register", "/bai2/change-password",
		"/bai2/edit-profile", "/bai2/forget-password", "/bai2/myFar" })
public class Bai2Servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		System.out.println(uri);
		if (uri.contains("/home")) {
			req.setAttribute("view", "/bai2/home.jsp");
		} else if (uri.contains("/login")) {
			req.setAttribute("view", "/bai2/login.jsp");
		} else if (uri.contains("/logout")) {
			req.setAttribute("view", "/bai2/logout.jsp");
		} else if (uri.contains("/register")) {
			req.setAttribute("view", "/bai2/register.jsp");
		} else if (uri.contains("/change-password")) {
			req.setAttribute("view", "/bai2/changePassword.jsp");
		} else if (uri.contains("/edit-profile")) {
			req.setAttribute("view", "/bai2/profile.jsp");
		} else if (uri.contains("/forget-password")) {
			req.setAttribute("view", "/bai2/forgetPassword.jsp");
		} else if (uri.contains("/myFar")) {
			req.setAttribute("view", "/bai2/myFar.jsp");
		}

		req.getRequestDispatcher("/bai2.jsp").forward(req, resp);
	}
}
