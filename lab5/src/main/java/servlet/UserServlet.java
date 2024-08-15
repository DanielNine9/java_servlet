package servlet;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import bean.User;
import dao.UserDAO;

@WebServlet({ "/user/index", "/user/edit/*", "/user/create", "/user/update", "/user/delete" })
public class UserServlet extends HttpServlet {
	private static final int DEFAULT_PAGE_SIZE = 3;


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		UserDAO dao = new UserDAO();
		User user = new User();
		
		System.out.println("full name "+ req.getParameter("fullname"));
	
		String uri = req.getRequestURI();
		System.out.println("uri >>> " + uri);
		int page = 1;
		int pageSize = DEFAULT_PAGE_SIZE;
		try {
			if (req.getParameter("page") != null) {
				page = Integer.parseInt(req.getParameter("page"));
			}

			
		}catch(NumberFormatException e) {
			
			
		}
		
		try {

			if (req.getParameter("pageSize") != null) {
				pageSize = Integer.parseInt(req.getParameter("pageSize"));
			}
			
		}catch(NumberFormatException e) {
			
			
		}
	
		
		System.out.println("page " + page);
		System.out.println("pageSize " + pageSize);

		req.setAttribute("edit", false);
		if (uri.contains("edit")) {
			String id = uri.substring(uri.lastIndexOf("/") + 1);
			user = dao.findById(id);
			req.setAttribute("edit", true);
			System.out.println("user: " + user);
		} else if (uri.contains("create")) {
			try {
				String id = req.getParameter("id");
				user = dao.findById(id);

				if (user != null) {
					req.setAttribute("message", "Username đã tồn tại.");
					req.setAttribute("form", null);
					req.setAttribute("items", dao.findAll(page, pageSize));
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
							req.setAttribute("items", dao.findAll(page, pageSize));
							req.getRequestDispatcher("/index.jsp").forward(req, resp);
							return;
						}
					}
				}

				BeanUtils.populate(user, req.getParameterMap());

				User createdUser = dao.create(user);

				if (createdUser != null) {
					user = null;
					req.setAttribute("success", "Thêm mới thành công");
				} else {
					req.setAttribute("message", "Thêm mới thất bại");
				}
			} catch (IllegalAccessException | InvocationTargetException e) {
				req.setAttribute("message", "Thêm mới thất bại");
				e.printStackTrace();
			}
		} else if (uri.contains("update")) {
			try {
				String id = req.getParameter("id");

				user = dao.findById(id);

				BeanUtils.populate(user, req.getParameterMap());

				dao.update(user);
				user = null;
				req.setAttribute("success", "Cập nhật thành công");
			} catch (IllegalAccessException | InvocationTargetException e) {
				req.setAttribute("message", "Cập nhật thất bại");
				e.printStackTrace();
			}
		} else if (uri.contains("delete")) {
			String id = req.getParameter("id");
			dao.remove(id);
			req.setAttribute("success", "Xoá thành công");
		}
		long totalItems = dao.count();
		System.out.println("totalItems " + totalItems);
		int totalPages = (int) Math.ceil((double) totalItems / pageSize);
		System.out.println("totalPages " + totalItems);
		// Set attributes for rendering in JSP
		req.setAttribute("form", user);
		req.setAttribute("items", dao.findAll(page, pageSize));
		req.setAttribute("currentPage", page);
		req.setAttribute("totalPages", totalPages);

		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
