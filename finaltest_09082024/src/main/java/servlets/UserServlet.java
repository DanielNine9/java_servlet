package servlets;

import java.io.File;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import bean.User;
import dao.UserDAO;

@WebServlet({ "/user/index", "/user/edit/*", "/user/create", "/user/update", "/user/delete", "/user/find" })
@MultipartConfig
public class UserServlet extends HttpServlet {
	private static final int DEFAULT_PAGE_SIZE = 5;

	public void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String find = req.getParameter("find");
		System.out.println("find " + find);
		UserDAO dao = new UserDAO();
		List<User> users = dao.find(find);

		req.setAttribute("items", users);

		req.setAttribute("form", null);
		req.getRequestDispatcher("/management/index.jsp").forward(req, resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		UserDAO dao = new UserDAO();
		User user = new User();

		String uri = req.getRequestURI();
		System.out.println("uri >>> " + uri);
		int page = 1;
		int pageSize = DEFAULT_PAGE_SIZE;
		try {
			if (req.getParameter("page") != null) {
				page = Integer.parseInt(req.getParameter("page"));
			}

		} catch (NumberFormatException e) {

		}

		try {

			if (req.getParameter("pageSize") != null) {
				pageSize = Integer.parseInt(req.getParameter("pageSize"));
			}

		} catch (NumberFormatException e) {

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
					req.getRequestDispatcher("/management/index.jsp").forward(req, resp);
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
							req.getRequestDispatcher("/management/index.jsp").forward(req, resp);
							return;
						}
					}
				}

				BeanUtils.populate(user, req.getParameterMap());
				String[] list = parameterMap.get("hobbies");
				arrayToString(list, user);
				uploadFile(req, user);
				String marriedReq = req.getParameter("married");
				Boolean married = marriedReq != null ? true : false;
				user.setMarried(married);
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
				Map<String, String[]> parameterMap = req.getParameterMap();

				user = dao.findById(id);
				if (user == null) {
					req.setAttribute("message", "Không tìm thấy id " + id);

				} else {
					System.out.println("id " + id);
					BeanUtils.populate(user, req.getParameterMap());
					String[] list = parameterMap.get("hobbies");
					
					
					arrayToString(list, user);
					uploadFile(req, user);
					String marriedReq = req.getParameter("married");
					Boolean married = marriedReq != null ? true : false;
					user.setMarried(married);
					dao.update(user);
					req.setAttribute("success", "Cập nhật thành công");
				}

				user = null;
			} catch (IllegalAccessException | InvocationTargetException e) {
				req.setAttribute("message", "Cập nhật thất bại");
				e.printStackTrace();
			}
		} else if (uri.contains("delete")) {
			String id = req.getParameter("id");
			dao.remove(id);
			req.setAttribute("success", "Xoá thành công");
		} else if (uri.contains("find")) {
			this.find(req, resp);
			return;

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

		req.getRequestDispatcher("/management/index.jsp").forward(req, resp);
	}

	public void uploadFile(HttpServletRequest request, User user) {
		String applicationPath = request.getServletContext().getRealPath("");
		String uploadFilePath = applicationPath + "img";
		File uploadDir = new File(uploadFilePath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		try {
			Part filePart = request.getPart("photo");
			if (filePart != null && filePart.getSubmittedFileName() != null
					&& !filePart.getSubmittedFileName().isEmpty()) {
				String fileName = filePart.getSubmittedFileName();
				filePart.write(uploadFilePath + File.separator + fileName);

				String relativePath = "/lab7/img" + File.separator + fileName;
				user.setImage(relativePath);

				System.out.println("Image uploaded to: " + relativePath);
			} else {
				System.out.println("No file uploaded or file part is empty.");
			}
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

	public static String arrayToString(String[] array, User user) {
		if (array == null || array.length == 0) {
			return "";
		}

		// Join the array elements with ", " separator
		String result = String.join(", ", array);

		// Replace the last comma with a period, if there is a comma
		if (result.endsWith(", ")) {
			result = result.substring(0, result.length() - 2) + ".";
		}
		user.setHobby(result);
		return result;
	}

}
