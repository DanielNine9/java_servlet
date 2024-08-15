//package listeners;
//
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.util.List;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSessionEvent;
//import javax.servlet.http.HttpSessionListener;
//
//@WebListener
//public class AppListener implements HttpSessionListener, ServletContextListener {
//	@Override
//	public void contextDestroyed(ServletContextEvent e) {
//		System.out.println("contextDestroyed");
//		ServletContext application = e.getServletContext();
//		Integer visitors = (Integer) application.getAttribute("visitors");
//		try {
//			String path = application.getRealPath("/visitors.txt");
//			byte[] data = String.valueOf(visitors).getBytes();
//			Files.write(Paths.get(path), data, StandardOpenOption.CREATE);
//		} catch (Exception e2) {
//			e2.printStackTrace();
//		}
//
//	}
//
//	@Override
//	public void contextInitialized(ServletContextEvent e) {
//		System.out.println("contextInitialized");
//		ServletContext application = e.getServletContext();
//		Integer visitors = 0;
//		try {
//			String path = application.getRealPath("/visitors.txt"); // đặt tại webroot
//			List<String> lines = Files.readAllLines(Paths.get(path));
//			System.out.println("lines " + lines.get(0));
//			visitors = Integer.valueOf(lines.get(0));
//		} catch (Exception e2) {
//			e2.printStackTrace();
//			visitors = 100000; // khởi đầu số khách
//		}
//		application.setAttribute("visitors", visitors);
//	}
//
//	@Override
//	public void sessionCreated(HttpSessionEvent e) {
//		System.out.println("sessionCreated");
//		HttpSession session = e.getSession();
//		ServletContext application = session.getServletContext();
//		Integer visitors = (Integer) application.getAttribute("visitors");
//		application.setAttribute("visitors", visitors + 1);
//	}
//
//	@Override
//	public void sessionDestroyed(HttpSessionEvent e) {
//		// No action needed on session destroy
//	}
//}
