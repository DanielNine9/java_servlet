package lab3;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/lab3bai1")
public class Lab3bai1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/lab3bai1.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Directory to save uploaded files, relative to the web app root
        File dir = new File(req.getServletContext().getRealPath("/uploads"));
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try {
            // Handle image file upload
            Part photo = req.getPart("photo_file");
            File photoFile = null;
            if (photo == null || photo.getSize() == 0) {
                req.setAttribute("error", "Vui lòng chọn đầy đủ hình ảnh và tài liệu");
                req.getRequestDispatcher("/lab3bai1.jsp").forward(req, resp);
                return;
            } else {
                String photoFileName = photo.getSubmittedFileName().replace(" ", "_");
                photoFile = new File(dir, photoFileName);
                photo.write(photoFile.getAbsolutePath());
            }

            // Handle document file upload
            Part doc = req.getPart("doc_file");
            File docFile = null;
            if (doc == null || doc.getSize() == 0) {
            	req.setAttribute("error", "Vui lòng chọn đầy đủ hình ảnh và tài liệu");
                req.getRequestDispatcher("/lab3bai1.jsp").forward(req, resp);
                return;
            } else {
                String docFileName = doc.getSubmittedFileName().replace(" ", "_");
                docFile = new File(dir, docFileName);
                doc.write(docFile.getAbsolutePath());
            }

            // Share files with result page to display
            req.setAttribute("img", photoFile != null ? photoFile.getName() : null);
            req.setAttribute("doc", docFile != null ? docFile.getName() : null);

            req.getRequestDispatcher("/resultBai1.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "File upload failed: " + e.getMessage());
            req.getRequestDispatcher("/lab3bai1.jsp").forward(req, resp);
        }
    }
}
