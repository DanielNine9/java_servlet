package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;

@WebServlet({ "/bai2", "/bai2/edit", "/bai2/delete", "/bai2/index.jsp" , "/bai2/refresh","/bai2/update",  })
public class Bai2Servlet extends HttpServlet {
	private List<User> users = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println(action);
        switch (action) {
            case "/bai2/edit":
                showEditForm(req, resp);
                break;
            case "/bai2/update":
            	updateUser(req, resp);
            	break;
            case "/bai2/delete":
                deleteUser(req, resp);
                break;
            case "/bai2/refresh":
            	req.setAttribute("user", null);
            	listUsers(req, resp);
            	break;
            case "/bai2/index.jsp":
	              req.getRequestDispatcher("/index.jsp").forward(req, resp);
	              break;
            default:
                listUsers(req, resp);
                break;
        }
	}
	
	private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username = req.getParameter("username");
        User existingUser = findUserByUsername(username);
        if(existingUser != null) {
            this.users.remove(existingUser);
	        req.setAttribute("users", this.users);
	        req.setAttribute("success", "Xóa user thành công");
			req.getRequestDispatcher("/bai2.jsp").forward(req, resp);
        	return;
        }
        req.setAttribute("message", "Không tìm thấy user");
        req.getRequestDispatcher("/bai2.jsp").forward(req, resp);
	}

	  private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String username = req.getParameter("username");
	        User existingUser = findUserByUsername(username);
	        req.setAttribute("user", existingUser);
	        req.setAttribute("users", this.users);
			req.getRequestDispatcher("/bai2.jsp").forward(req, resp);
	    }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
			req.setAttribute("message", "Vui lòng nhập đầy đủ username và password");
			req.getRequestDispatcher("bai2.jsp").forward(req, resp);
			return;
		}

		boolean usernameExists = false;
		for (User user : this.users) {
			if (user.getUsername().equals(username)) {
				usernameExists = true;
				break;
			}
		}

		if (usernameExists) {
			req.setAttribute("message", "Username đã tồn tại");
		} else {
			this.users.add(new User(username, password, remember != null ? true : false));
			req.setAttribute("success", "Thêm user thành công");
		}
		

		req.setAttribute("users", this.users);
		req.getRequestDispatcher("bai2.jsp").forward(req, resp);

	}

	private void listUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("users", this.users);
		 req.getRequestDispatcher("/bai2.jsp").forward(req, resp);
	}

	private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String originalUsername = req.getParameter("originalUsername");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");

		User existingUser = findUserByUsername(originalUsername);

		if (existingUser != null) {
			existingUser.setUsername(username);
			existingUser.setPassword(password);
			existingUser.setRemember(remember != null);
			req.setAttribute("success", "Chỉnh sửa user thành công");
		}

		listUsers(req, resp);
	}

	private User findUserByUsername(String username) {
		for (User user : this.users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
}
