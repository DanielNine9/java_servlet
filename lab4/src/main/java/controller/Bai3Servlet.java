package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Product;
import models.User;

@WebServlet({ "/bai3", "/bai3/detail/*", "/bai3/buy/*", "/bai3/cart/*" })
public class Bai3Servlet extends HttpServlet {

	private ArrayList<Product> products = new ArrayList<>();

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		products.add(new Product("Iphone 11",
				"https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcS_-CxkyJsIA--HtDvAiLwFf_V8DYJtBN_-5UWFj8tJncyLNFb0UWtWhF6Z1uDmBuWUPDWEmB9PnPpXvNuE91Del_nwKOrwIIWj-cOlVZlwkSZiTTc2fjurO8RMEt22GxrOin918kbwAMo&usqp=CAc",
				1000, 0.2));
		products.add(new Product("Iphone 12",
				"https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcRrJEULnCPViXkH6zuEo_prts-ovmL7o2EceDCmCKE4BuaSZsHyysfNF6IRkSmn80utm5f62ZE9sXbKbbDptCpZEuuBazM6htLrg8h3oAmb5ElP7oARoBXDeS1WCzaGNf5kJt5m2Q&usqp=CAc",
				2000, 0.4));
		products.add(new Product("Laptop",
				"https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcQUJgM1Tt1EHoDmS-4R0Ys2PS82SWdis1yfe7G-qyp8sUIzGzCOLO-pt3oY9O2znWajA-0XYxgmNnLJ71owYaeEp01YqPL04cX3I3RQAiF7SCLexQXEi0iY_nk_1pDtvffwEK5AHHoIsFc&usqp=CAc",
				3000, 0.3));
		products.add(new Product("Acer Nitro 5",
				"data:image/webp;base64,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",
				3000, 0.3));
		products.add(new Product("Macbook pro m1 14 inch",
				"https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcSucPyfiGBlmnC7el7pPkL2uNReJ0CZMabPBiFL1xeMo6Cw_4SnLDRZXnVwFcqVeA4XCoI-MvrBrYm8LaOJDWsD63rKbMCBPwBKl7ilTqScj3Arkkg8e-ZK2M9OKA&usqp=CAc",
				3000, 0.3));
		products.add(new Product("Macbook air m3",
				"https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcSEm2_RllJgpLtYIzTotGT8n6g54K7U7xh3AWPvWBx2XrIGCH8MSusjLOtFNpnLq_1eTIpujtMRQZhrEIXiN56vkmCRr_tA5ABUB7dYGTve-2Ek-l81T4nbCVoKxlskqxphTx9W-Q&usqp=CAc",
				3000, 0.3));
		products.add(new Product("Macbook pro m1 13.3 inch",
				"https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcRgMqyDkzJrHU-MFR1JeLndZp5umQzShw6LbjVVrnsl1kFtUUeKpCiaJ6ewZCfrHitQcrQxgh4UNELvmEV7cMbZh3zakuu3hc9KW8iMkjf-UCuHTdFLMbXhLFWbW_WjSxYcyhdoog&usqp=CAc",
				9, 0.3));
		products.add(new Product("Lenovo Gaming",
				"data:image/webp;base64,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",
				1000, 0.2));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = req.getServletPath();
		System.out.println(action);
		switch (action) {

		case "/bai3/detail":
			handleDetail(req, resp);
			break;
		case "/bai3/cart":
            // Assuming you have a session attribute named "cartItems" containing the items in the cart
            List<Product> cartItems = (List<Product>) req.getSession().getAttribute("cartItems");
            if (cartItems != null && !cartItems.isEmpty()) {
                req.getRequestDispatcher("/cart.jsp").forward(req, resp);
            } else {
                req.setAttribute("success", "Your cart is empty.");
                req.getRequestDispatcher("/cart.jsp").forward(req, resp);
            }
            break;
		default:
			req.setAttribute("items", this.products);
			req.getRequestDispatcher("/bai3.jsp").forward(req, resp);
			break;
		}

		super.doGet(req, resp);
	}

	private void handleDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		System.out.println(pathInfo);
		if (pathInfo != null && pathInfo.length() > 1) {
			String idP = pathInfo.substring(1);

			try {
				Product product = this.findProductById(Integer.parseInt(idP));
				if (product == null) {
					req.setAttribute("message", "Không tìm thấy sản phẩm");
					req.getRequestDispatcher("/bai4.jsp").forward(req, resp);
					return;
				}

				req.setAttribute("item", product);
				req.getRequestDispatcher("/bai4.jsp").forward(req, resp);
			} catch (NumberFormatException e) {
				req.setAttribute("message", "ID sản phẩm không hợp lệ");
				req.getRequestDispatcher("/bai4.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("message", "ID sản phẩm không hợp lệ");
			req.getRequestDispatcher("/bai4.jsp").forward(req, resp);
		}
	}

	private Product findProductById(int id) {
		for (Product product : this.products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}
	
	private void handleBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(); // Get session object
	    
	    String productId = request.getPathInfo().substring(1); // Assuming /bai3/buy/{id}
	    Product product = findProductById(Integer.parseInt(productId));
	    
	    if (product != null) {
	        // Get existing cart items from session or create a new list
	        List<Product> cartItems = (List<Product>) session.getAttribute("cartItems");
	        
	        if (cartItems == null) {
	            cartItems = new ArrayList<>();
	            session.setAttribute("cartItems", cartItems);
	        }
	        
	        // Check if the product is already in the cart
	        boolean productFoundInCart = false;
	        for (Product item : cartItems) {
	            if (item.getId() == product.getId()) {
	                // Increment quantity of existing product in cart
	                item.setQuantity(item.getQuantity() + 1);
	                productFoundInCart = true;
	                break;
	            }
	        }
	        
	        // If product is not found in cart, add it with quantity 1
	        if (!productFoundInCart) {
	            product.setQuantity(1); // Assuming you have a quantity field in Product
	            cartItems.add(product);
	        }
	        
	        request.setAttribute("success", "Product has been added to your cart");
	        request.getRequestDispatcher("/cart.jsp").forward(request, response);
	    } else {
	        // Handle case where product is not found
	        request.setAttribute("items", this.products);
	        request.getRequestDispatcher("/bai3.jsp").forward(request, response);
	    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println(action);
		switch (action) {
		case "/bai3/buy":
			handleBuy(req, resp);
			break;
		default:
			req.setAttribute("items", this.products);
			req.getRequestDispatcher("/bai3.jsp").forward(req, resp);
			break;
		}

	}
}
