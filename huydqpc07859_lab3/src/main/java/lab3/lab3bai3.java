package lab3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lab3bai3")
public class lab3bai3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = CookieUtils.get("username", req);
		String password = CookieUtils.get("password", req);
		String remember = CookieUtils.get("remember", req); 
		System.out.println(remember);
		if(remember.equals("true")) {
			req.setAttribute("username", username);
			req.setAttribute("password", password);
			req.setAttribute("remember", true);
			
		}

		req.getRequestDispatcher("/lab3bai3.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		boolean isRememberChecked = remember != null ? true : false;
		if(username.isBlank() || password.isBlank()) {
			req.setAttribute("error", "Vui lòng nhập đầy đủ tài khoản mật khẩu.");
			req.getRequestDispatcher("/lab3bai3.jsp").forward(req, resp);
			return;
		}
		if (!username.equalsIgnoreCase("huydqpc07859")) {
			req.setAttribute("error", "Sai tên đăng nhập!");
		} else if (!password.equals("12341234")) {
			req.setAttribute("error", "Sai mật khẩu!");
		} else {
			req.setAttribute("message", "Đăng nhập thành công.");

			int hours = isRememberChecked ? 30 * 24 : 0; 
			if(isRememberChecked) {
				CookieUtils.add("username", username, hours, resp);
				CookieUtils.add("password", password, hours, resp);
				CookieUtils.add("remember", "true", hours, resp);
				req.setAttribute("username", username);
				req.setAttribute("password", password);
				req.setAttribute("remember", true);
			}else {
				CookieUtils.add("remember", "false", hours, resp);
			}

		}

		req.getRequestDispatcher("/lab3bai3.jsp").forward(req, resp);
	}
}
