package servlet;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/lang/change/*" })
public class LangServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		HttpSession session = req.getSession();
		String pathInfo = req.getPathInfo();
		System.out.println(pathInfo);
		if (pathInfo != null && pathInfo.length() > 1) {
			session.setAttribute("lang", pathInfo.substring(1));
		}
		req.setAttribute("view", "/home.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		super.doGet(req, resp);
	}
}
