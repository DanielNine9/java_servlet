package servlets;

import java.io.File;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

@MultipartConfig
@WebServlet({ "/user/index", "/user/edit/*", "/user/create", "/user/update", "/user/delete" , "/user/find"})
public class UserServlet extends HttpServlet {
	private static final int DEFAULT_PAGE_SIZE = 5;

	
	public String uploadPhoto(HttpServletRequest req, HttpServletResponse resp) {
		
       File dir = new File(req.getServletContext().getRealPath("/uploads"));
       if (!dir.exists()) {
           dir.mkdirs();
       }

       try {
           Part photo = req.getPart("photo_file");
           File photoFile = null;
           if (photo == null || photo.getSize() == 0) {
//               req.setAttribute("error", "Vui lòng chọn ảnh");
//               return null;
           } else {
        	   String uuid = UUID.randomUUID().toString();
        	   
//               String photoFileName = photo.getSubmittedFileName().replace(" ", "_");
               String photoFileName = UUID.randomUUID().toString() + ".png";
               photoFile = new File(dir, photoFileName);
               System.out.println(photoFile);
               photo.write(photoFile.getAbsolutePath());
           }
           return photoFile != null ? photoFile.getName() : "";

       } catch (Exception e) {
           e.printStackTrace();
           req.setAttribute("message", "Image upload failed: " + e.getMessage());
           return null;
       }
	}
	
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
		int page = 1;
		int pageSize = DEFAULT_PAGE_SIZE;
		UserDAO dao = new UserDAO();
		User user = new User();
		
//		Checkbox
		String marriedReq = req.getParameter("married");
		Boolean married = marriedReq != null ? true : false;
		System.out.println("married " + married);
		String uri = req.getRequestURI();
		System.out.println("uri >>> " + uri);
		
		
		
		try {
			if (req.getParameter("page") != null) {
				page = Integer.parseInt(req.getParameter("page"));
			}

			
		}catch(NumberFormatException e) {
			
			
		}
		
		try {

			if (req.getParameter("pageSize") != null) {
				pageSize = Integer.parseInt(req.getParameter("pageSize"));
			}
			
		}catch(NumberFormatException e) {
			
			
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
				String urlPhoto = this.uploadPhoto(req, resp);
				if(urlPhoto == null) {
					long totalItems = dao.count();
					System.out.println("totalItems " + totalItems);
					int totalPages = (int) Math.ceil((double) totalItems / pageSize);
					System.out.println("totalPages " + totalItems);
					req.setAttribute("form", user);
					req.setAttribute("items", dao.findAll(page, pageSize));
					req.setAttribute("currentPage", page);
					req.setAttribute("totalPages", totalPages);
					req.setAttribute("message", "Please, choose an image");

					req.getRequestDispatcher("/management/index.jsp").forward(req, resp);
					return;
				}
				String id = req.getParameter("id");
				user = dao.findById(id);

				if (user != null) {
					req.setAttribute("message", "Username đã tồn tại.");
					req.setAttribute("form", null);
					req.setAttribute("items", dao.findAll(page, pageSize));
					req.getRequestDispatcher("/management/index.jsp").forward(req, resp);
					return;
				}
//				thầy Liêm: liemht6@fe.edu.vn
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

//				user.setMarried(married);
				if(urlPhoto != "") {
					user.setImage(urlPhoto);
				}
	

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
				String urlPhoto = this.uploadPhoto(req, resp);
				if(urlPhoto == null) {
					long totalItems = dao.count();
					System.out.println("totalItems " + totalItems);
					int totalPages = (int) Math.ceil((double) totalItems / pageSize);
					System.out.println("totalPages " + totalItems);
					req.setAttribute("form", user);
					req.setAttribute("items", dao.findAll(page, pageSize));
					req.setAttribute("currentPage", page);
					req.setAttribute("totalPages", totalPages);
					req.setAttribute("message", "Please, choose an image");

					req.getRequestDispatcher("/management/index.jsp").forward(req, resp);
					return;
				}
				String id = req.getParameter("id");

				user = dao.findById(id);
				if(user == null) {
					req.setAttribute("message", "Không tìm thấy id " + id);
					
				}else {
					System.out.println("id " + id);
					BeanUtils.populate(user, req.getParameterMap());

//					user.setMarried(married);
					if(urlPhoto != "") {
						user.setImage(urlPhoto);
					}
		
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

}
