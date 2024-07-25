package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Product;

@WebServlet({"/cart/delete", "/cart/update"})
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri =  request.getRequestURI();
        System.out.println("vao day " + request.getRequestURI());
        HttpSession session = request.getSession();
        
        try {
        	List<Product> cartItems = (List<Product>) session.getAttribute("cartItems");
            int id = Integer.parseInt(request.getParameter("id"));
            if (uri.contains("/cart/delete")) {
                cartItems.removeIf(product -> product.getId() == id);
                session.setAttribute("cartItems", cartItems);
                request.setAttribute("success", "Deleting successfully");
                request.getRequestDispatcher("/cart.jsp").forward(request, response);
            } else if (uri.contains("/cart/update")) {
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                for (Product product : cartItems) {
                    if (product.getId() == id) {
                        product.setQuantity(quantity);
                        break;
                    }
                }
                session.setAttribute("cartItems", cartItems);
                request.setAttribute("success", "Updating successfully");
                request.getRequestDispatcher("/cart.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
        	e.printStackTrace();
            request.setAttribute("message", "Something went wrong.");
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        }
    }
}
