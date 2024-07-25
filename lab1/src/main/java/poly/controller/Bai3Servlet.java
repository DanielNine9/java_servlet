package poly.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bai3")
public class Bai3Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("bai3.jsp").forward(req, resp);;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Double a,b;
		String txtA = req.getParameter("a");
		String txtB = req.getParameter("b");
		if(txtA == "" || txtB == "") {
			req.setAttribute("error", "Phải nhập đầy đủ");
			req.getRequestDispatcher("bai3.jsp").forward(req, resp);
	
			return;
		}
		a= Double.valueOf(txtA);
		b= Double.valueOf(txtB);
		
		
		String phepTinh = req.getParameter("selectPhepTinh");
		System.out.println(phepTinh);
		Double result = 0.0;
		switch(phepTinh) {
			case "+":
				result  = a + b;
				break;
			case "-":
				result  = a - b;
				break;
			case "*":
				result  = a * b;
				break;
			case "/":
				result  = a / b;
				break;
			default: 
				result = a + b;}
		req.setAttribute("result", result);
		req.setAttribute("a", a);
		req.setAttribute("b", b);
		req.getRequestDispatcher("bai3.jsp").forward(req, resp);
		
		
	}
}
