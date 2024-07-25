package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/lab6bai1", "/test"})
public class Bai1Servlet extends HttpServlet {

	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String uri = req.getRequestURI();
			if(uri.contains("find-userID")) {
				req.getRequestDispatcher("/bai1.jsp").forward(req, resp);
			}else if(uri.contains("find-videoTitle")) {
				req.getRequestDispatcher("/bai1.jsp").forward(req, resp);
			}else if(uri.contains("find-userLikeVideo")) {
				req.getRequestDispatcher("/bai1.jsp").forward(req, resp);
			}else if(uri.contains("find-favorite")) {
				req.getRequestDispatcher("/bai1.jsp").forward(req, resp);
			}else if(uri.contains("favorite-count")) {
				req.getRequestDispatcher("/bai1.jsp").forward(req, resp);
			}
			
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		}
}
