package lab3;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

@MultipartConfig
@WebServlet("/lab3bai2")
public class lab3bai2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/lab3bai2.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Staff staff = new Staff();

			// Validate required fields
			String name = req.getParameter("fullname");
			String country = req.getParameter("country");
			String gender = req.getParameter("gender");
			String birthdayStr = req.getParameter("birthday");
			String[] hobbies = req.getParameterValues("hobbies"); // Retrieve multiple checkbox values
			Part photo = req.getPart("photo");

			// Check for required fields
			if (name == null || name.isEmpty() || birthdayStr == null || birthdayStr.isEmpty()
					|| (photo == null || photo.getSize() == 0) || hobbies == null || hobbies.length == 0) {

				req.setAttribute("error", "Vui lòng điền tất cả các trường.");
				req.getRequestDispatcher("/lab3bai2.jsp").forward(req, resp);
				return;
			}
			StringBuilder sb = new StringBuilder();
			for (String hobby : hobbies) {
				sb.append(", ").append(hobby);
			}
			System.out.println(sb.toString());
			String hobbiesString = sb.toString().substring(2);
			System.out.println(hobbiesString);
			System.out.println(staff.getHobbies());
			// Create directory to save the file if it does not exist
			File dir = new File(req.getServletContext().getRealPath("/files"));
			if (!dir.exists()) {
				dir.mkdirs();
			}

			// Save the uploaded photo file
			File photoFile = new File(dir, photo.getSubmittedFileName());
			photo.write(photoFile.getAbsolutePath());
			staff.setPhoto(photoFile.getName());

			staff.setHobbies(hobbiesString);

			req.setAttribute("hobbies",hobbiesString);
			// Populate the staff bean with request parameters
			BeanUtils.populate(staff, req.getParameterMap());

			staff.setBirthday(birthdayStr);

			// Share with result.jsp
			req.setAttribute("staff", staff);
			req.getRequestDispatcher("/resultBai2.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Có lỗi xảy ra: " + e.getMessage());
			req.getRequestDispatcher("/lab3bai2.jsp").forward(req, resp);
		}
	}
}
