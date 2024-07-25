package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bai3")
public class Bai3Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private int count;
    private Path path = Paths.get("C:\\Users\\dinhh\\Desktop\\java\\huydqpc07859_lab2\\count.txt");

    @Override
    public void init() throws ServletException {
        try {
            System.out.println("File path: " + path.toAbsolutePath());

            if (!Files.exists(path)) {
                Files.createFile(path); 
                Files.write(path, List.of("0")); 
            }
            count = Integer.parseInt(Files.readAllLines(path).get(0));
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Increment the count
        count++;

        req.setAttribute("count", count);

        req.getRequestDispatcher("/bai3.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        try {
            Files.write(path, String.valueOf(count).getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("bai3.jsp").forward(req, resp);
    }
}
