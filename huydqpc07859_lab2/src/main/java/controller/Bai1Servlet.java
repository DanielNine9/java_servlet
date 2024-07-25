package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/bai1", "/chuvi", "/dientich" })
public class Bai1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("bai1.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String txtA = req.getParameter("txta");
	    String txtB = req.getParameter("txtb");
	    String txtC = req.getParameter("txtc");
	    String chuvi = req.getParameter("chuvi");
	    String dientich = req.getParameter("dientich");
	    String uri = req.getRequestURI();
	    
	    
	    req.setAttribute("txtA", txtA);
	    req.setAttribute("txtB", txtB);
	    req.setAttribute("txtC", txtC);
	    
	    
	    if (txtA.isEmpty() || txtB.isEmpty() || txtC.isEmpty()) {
	        req.setAttribute("message", "Vui lòng nhập đầy đủ tất cả các trường.");
	        req.getRequestDispatcher("bai1.jsp").forward(req, resp);
	        return;
	    }
	    
	    double a = Double.parseDouble(txtA);
	    double b = Double.parseDouble(txtB);
	    double c = Double.parseDouble(txtC);
	    
	    if (a + b <= c || a + c <= b || b + c <= a) {
	        req.setAttribute("message", "Các cạnh nhập vào không tạo thành một tam giác.");
	        req.getRequestDispatcher("bai1.jsp").forward(req, resp);
	        return;
	    }
	    
	    if (uri.contains("chuvi")) {
	        double chuVi = a + b + c;
	        req.setAttribute("chuvi", chuVi);
	    } 
	    
	    if (uri.contains("dientich")) {
	        double s = (a + b + c) / 2;
	        double dienTich = Math.sqrt(s * (s - a) * (s - b) * (s - c));
	        req.setAttribute("dientich", dienTich);
	    }
	    
	    req.getRequestDispatcher("bai1.jsp").forward(req, resp);
	}

}
