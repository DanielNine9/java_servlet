package servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import bean.User;
import dao.UserDAO;

@WebServlet({ "/auth/login", "/auth/register", "/auth/home", "/auth/logout", })
public class AuthServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String uri = req.getRequestURI();
		String method = req.getMethod();
		if ("get".equalsIgnoreCase(method)) {
			if (uri.contains("login")) {
				req.setAttribute("view", "/login.jsp");
			} else if (uri.contains("register")) {
				req.setAttribute("view", "/register.jsp");
			} else if (uri.contains("home")) {
				req.setAttribute("view", "/home.jsp");
			}
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else {
			if (uri.contains("login")) {
				
				handleLogin(req, resp);
			} else if (uri.contains("register")) {
				handleRegister(req, resp);
			} else if (uri.contains("logout")) {
				handleLogout(req, resp);

			}

		}

	}

	public void handleLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("logout");
		
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		req.setAttribute("view", "/login.jsp");
		req.setAttribute("success", "Đăng xuất thành công");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	public void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		User user = new User();
		System.out.println("usename " + req.getParameter("id"));
		System.out.println("password " + req.getParameter("password"));
		String usernameString = req.getParameter("id");
		String passwordString = req.getParameter("password");

		if (usernameString == null || passwordString == null || usernameString.isBlank() || passwordString.isBlank()) {
			req.setAttribute("message", "Vui lòng nhập đầy đủ tài khoản và mật khẩu.");
			req.setAttribute("view", "/login.jsp");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		try {
			String id = req.getParameter("id");
			user = dao.findById(id);
			if (user == null) {
				req.setAttribute("message", "Username chưa đăng ký với hệ thống.");
				req.setAttribute("view", "/login.jsp");
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				return;
			}

			String password = req.getParameter("password");

			if (!password.equals(user.getPassword())) {
				req.setAttribute("message", "Tài khoản hoặc mật khẩu không chính xác.");
				req.setAttribute("view", "/login.jsp");
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				return;
			}

			HttpSession session = req.getSession();

			session.setAttribute("user", user);
			req.setAttribute("view", "/home.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("message", "Đăng nhập thất bại");
			req.setAttribute("view", "/login.jsp");
		}
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	public void handleRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		User user = new User();
		
		String usernameString = req.getParameter("id");
		String passwordString = req.getParameter("password");
		String fullnameString = req.getParameter("fullname");

		if (usernameString == null || passwordString == null  || fullnameString == null|| usernameString.isBlank() || passwordString.isBlank() || fullnameString.isBlank()) {
			req.setAttribute("message", "Vui lòng nhập đầy đủ thông tin đăng ký.");
			req.setAttribute("view", "/register.jsp");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		try {
			String id = req.getParameter("id");
			user = dao.findById(id);

			if (user != null) {
				req.setAttribute("message", "Username đã tồn tại.");
				req.setAttribute("view", "/register.jsp");
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				return;
			}

			String password = req.getParameter("password");
			String confirm = req.getParameter("confirmPassword");

			if (!password.equals(confirm)) {
				req.setAttribute("message", "Mật khẩu và xác nhận mật khẩu phải trùng khớp.");
				req.setAttribute("view", "/register.jsp");
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				return;

			}

			user = new User();

			Map<String, String[]> parameterMap = req.getParameterMap();
			for (String paramName : parameterMap.keySet()) {
				String[] paramValues = parameterMap.get(paramName);
				for (String paramValue : paramValues) {

					System.out.println(paramName + ": " + paramValue);
					if (paramValue == "") {
						req.setAttribute("message", "Vui lòng nhập đầy đủ tất cả các trường");
						req.setAttribute("form", null);
						req.setAttribute("items", dao.findAll());
						req.getRequestDispatcher("/index.jsp").forward(req, resp);
						return;
					}
				}
			}

			BeanUtils.populate(user, req.getParameterMap());

			User createdUser = dao.create(user);

			if (createdUser != null) {
				user = null;
				req.setAttribute("success", "Đăng ký thành công");
				req.setAttribute("view", "/login.jsp");
			} else {
				req.setAttribute("message", "Đăng ký thất bại");
				req.setAttribute("view", "/register.jsp");
			}
		} catch (Exception e) {
			req.setAttribute("message", "Đăng ký thất bại");
			req.setAttribute("view", "/register.jsp");
		}
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
