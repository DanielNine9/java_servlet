package com.poly.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.dao.DAO_User;
import com.poly.model.User;

@WebServlet({"/Bai3_LoginServlet","/accountBai3/sign-in","/Bai3_LoginServlet/*"})
public class Bai3_LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// gá cho user là null mỗi khi logout
		request.getSession().setAttribute("user", null);
		
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		
		if(uri.contains("sign-in")) {
			signIn(request, response);
		}
		
	}
	private void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("userID");
			String pw = request.getParameter("password");
			
			DAO_User dao = new DAO_User();
			
			User user = dao.findByID(id);
			System.out.println("user: "+user.getUserID());
			System.out.println("pw : "+user.getPassword());
			if(user != null) {
				if(!user.getPassword().equalsIgnoreCase(pw)) {
					request.setAttribute("message", "Sai mật khẩu!");
					request.getRequestDispatcher("/views/login.jsp").forward(request, response);
				}else {
					request.getSession().setAttribute("messageHomePage", "Đăng Nhập thành công");
			
					request.getSession().setAttribute("user", user);
				
					request.getRequestDispatcher("/views/homepage.jsp").forward(request, response);
					///
				      
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
