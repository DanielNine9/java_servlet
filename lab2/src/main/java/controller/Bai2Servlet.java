package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bai2")
public class Bai2Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("bai2.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			  request.setCharacterEncoding("UTF-8");
			  
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String genderTxt = request.getParameter("gender") ;
			String married = request.getParameter("married") != null ? "Đã kết hôn" : "Chưa kết hôn";
			String countryTxt = request.getParameter("country");

			

			String[] hobbies = request.getParameterValues("hobbies");

			String notes = request.getParameter("notes");
			System.out.println("----");
			if (username == null || username.isEmpty() || password == null || password.isEmpty() || genderTxt == null
					|| genderTxt.isEmpty() || countryTxt == null || countryTxt.isEmpty() || hobbies == null || hobbies.length == 0) {
				request.setAttribute("error", "Vui lòng điền đầy đủ thông tin.");
				request.getRequestDispatcher("bai2.jsp").forward(request, response);
				return;
			}
			StringBuilder sb = new StringBuilder();
			for (String hobby : hobbies) {
			    sb.append(", ").append(hobby); 
			}
			String hobbiesString = sb.toString().substring(2);

			
			String country = countryTxt.equalsIgnoreCase("vn") ? "Việt Nam" : countryTxt.equalsIgnoreCase("tq") ? "Trung Quốc" : "Mỹ";
			String gender = genderTxt.equalsIgnoreCase("true") ? "Nam": "Nữ";
			// Proceed to set attributes and forward to result.jsp
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("gender", gender);
			request.setAttribute("married", married);
			request.setAttribute("country", country);
			request.setAttribute("hobbies",hobbiesString);
			request.setAttribute("notes", notes);

			System.out.println("username " + username);
			System.out.println("password " + password);
			System.out.println("gender " + gender);
			System.out.println("married " + married);
			System.out.println("country " + country);
			System.out.println("hobbies " + hobbiesString);
			System.out.println("notes " + notes);

			request.getRequestDispatcher("result.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
			response.getWriter().println("Error: " + e.getMessage());
		}
	}

}
