package lab3;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/lab3bai4")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,      // 10MB
                 maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class lab3bai4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/lab3bai4.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String to = req.getParameter("to");
        String subject = req.getParameter("subject");
        String messageContent = req.getParameter("message");

        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + messageContent);

        if (to == null || to.isEmpty() || subject == null || subject.isEmpty() || messageContent == null
                || messageContent.isEmpty()) {
            req.setAttribute("error", "Vui lòng nhập tất cả các trường.");
            req.getRequestDispatcher("/lab3bai4.jsp").forward(req, resp);
            return;
        }

        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new Authenticator() {
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    String username = "huydqpc07859@fpt.edu.vn";
                    String password = "bbna yyev jfji hkol";
                    return new javax.mail.PasswordAuthentication(username, password);
                }
            });

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress("huydqpc07859@fpt.edu.vn"));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            mimeMessage.setSubject(subject, "utf-8");

            MimeMultipart multipart = new MimeMultipart();

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(messageContent, "text/html; charset=utf-8");
            multipart.addBodyPart(textPart);

            Part filePart = req.getPart("attachment");
            if (filePart != null && filePart.getSize() > 0) {
                File uploadsDir = new File(req.getServletContext().getRealPath("/files"));
                if (!uploadsDir.exists()) {
                    uploadsDir.mkdir();
                }
                File file = new File(uploadsDir, filePart.getSubmittedFileName());
                filePart.write(file.getAbsolutePath());

                MimeBodyPart fileBodyPart = new MimeBodyPart();
                fileBodyPart.attachFile(file);
                multipart.addBodyPart(fileBodyPart);
            }

            // Set the content of the message
            mimeMessage.setContent(multipart);

            // Send the message
            Transport.send(mimeMessage);

            String successMessage = "Đã gửi mail đến " + to + " thành công";
            req.setAttribute("message", successMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            req.setAttribute("error", "Failed to send email: " + e.getMessage());
        }

        req.getRequestDispatcher("/lab3bai4.jsp").forward(req, resp);
    }
}
