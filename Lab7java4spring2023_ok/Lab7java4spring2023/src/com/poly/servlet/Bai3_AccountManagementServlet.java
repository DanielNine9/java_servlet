package com.poly.servlet;


import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.DAO_User;
import com.poly.model.User;

@WebServlet({ "/Bai3_AccountManagementServlet", "/UserServletBai3/Create", "/UserServletBai3/Update", "/UserServletBai3/Delete",
		"/UserServletBai3/Reset", "/UserServletBai3/Edit" })
public class Bai3_AccountManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		User user = null;
		if (uri.contains("Delete")) {
			remove(request, response);
			user = new User();
			request.setAttribute("user", user);
		}
		if (uri.contains("Reset")) {
			user = new User();
			request.setAttribute("user", user);
			request.setAttribute("disabled", "");
		}
		if (uri.contains("Edit")) {
			edit(request, response);
		}

		findALL(request, response);
		request.getRequestDispatcher("/views/userManagement.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
		if (uri.contains("Create")) {
			create(request, response);
		}
		if (uri.contains("Update")) {
			update(request, response);
		}
		if (uri.contains("Delete")) {
			remove(request, response);
			request.setAttribute("user", new User());
		}
		if (uri.contains("Reset")) {
			request.setAttribute("disabled", "");
			request.setAttribute("user", new User());
		}

		findALL(request, response);
		request.getRequestDispatcher("/views/userManagement.jsp").forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());

			DAO_User dao = new DAO_User();
			dao.create(user);
			request.setAttribute("message", "User created Successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userID = request.getParameter("userID");

			DAO_User dao = new DAO_User();
			User user = dao.findByID(userID);
			request.setAttribute("disabled", "disabled");
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());

			DAO_User dao = new DAO_User();
			dao.update(user);
			request.setAttribute("disabled", "");
			request.setAttribute("message", "User updated Successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("disabled", "disabled");
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("userID");
			DAO_User dao = new DAO_User();
			dao.delete(id);
			request.setAttribute("message", "User removed Successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	private void findALL(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			DAO_User dao = new DAO_User();
			List<User> list = dao.findAll();
			request.setAttribute("users", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
}
