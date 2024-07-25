package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Favorite;
import bean.Report;
import bean.User2;
import bean.Video;
import dao.ReportDAO;
import dao.UserDAO;
import dao.VideoDAO;

@WebServlet({ "/find/find-userID", "/find/find-videoTitle", "/find/find-userLikeVideo", "/find/find-favorite",
		"/find/choose-month", "/find/from-to", "/find/favorite-count", "/find/choose-year" })
public class FindServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		System.out.println("uri >>> " + uri);
		String method = req.getMethod();
		System.out.println("method >>> " + method);
		if ("post".equalsIgnoreCase(method)) {
			if (uri.contains("find-userID")) {
				this.findUserID(req, resp);
			} else if (uri.contains("find-videoTitle")) {
				this.findVideoTitle(req, resp);
			} else if (uri.contains("find-userLikeVideo")) {
				this.findUserLikeVideo(req, resp);
			} else if (uri.contains("find-favorite")) {
				this.findFavorite(req, resp);
			} else if (uri.contains("favorite-count")) {
				this.favoriteCount(req, resp);
			} else if (uri.contains("list-videos")) {
				this.listVideo(req, resp);
			} else if (uri.contains("from-to")) {
				this.fromTo(req, resp);
			} else if (uri.contains("choose-month")) {
				this.chooseMonth(req, resp);
			} else if (uri.contains("choose-year")) {
				this.chooseYear(req, resp);
			}
		} else {
			req.setAttribute("user", null);
			req.setAttribute("favorites", new ArrayList<>());
			req.setAttribute("users", new ArrayList<>());
			req.setAttribute("reports", new ArrayList<>());
			if (uri.contains("find-userID")) {
				req.getRequestDispatcher("/lab6/find-userID.jsp").forward(req, resp);
			} else if (uri.contains("find-videoTitle")) {
				req.getRequestDispatcher("/lab6/findVideoTitle.jsp").forward(req, resp);
			} else if (uri.contains("find-userLikeVideo")) {
				req.getRequestDispatcher("/lab6/findUserLikeVideo.jsp").forward(req, resp);
			} else if (uri.contains("find-favorite")) {
				req.getRequestDispatcher("/lab6/findFavorite.jsp").forward(req, resp);
			} else if (uri.contains("favorite-count")) {
				this.favoriteCount(req, resp);
			} else if (uri.contains("from-to")) {
				req.getRequestDispatcher("/lab6/fromTo.jsp").forward(req, resp);
			} else if (uri.contains("choose-month")) {
				req.getRequestDispatcher("/lab6/chooseMonth.jsp").forward(req, resp);
			} else if (uri.contains("choose-year")) {
				req.getRequestDispatcher("/lab6/chooseYear.jsp").forward(req, resp);
			}

		}

	}

	private void chooseYear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String methodString = req.getMethod();
		if(req.getParameter("year") == null){
			req.setAttribute("error", "Please choose year.");
		} else 
		if (methodString.equalsIgnoreCase("post")) {
			try {
				int year = Integer.parseInt(req.getParameter("year"));
				ReportDAO dao = new ReportDAO();
				List<Report> reports = dao.favoriteByYear(year);
				req.setAttribute("message", "Year: "+ year);
				req.setAttribute("reports", reports);
			} catch (Exception e) {
				System.out.println(e);
				req.setAttribute("error", "An error occurred while fetching the reports.");
			}
		}
		req.getRequestDispatcher("/lab6/chooseYear.jsp").forward(req, resp);
	}

	private void chooseMonth(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String methodString = req.getMethod();
		if (req.getParameterValues("months") == null) {
			req.setAttribute("error", "Please, choose at less 1 month");

		} else if (methodString.equalsIgnoreCase("post")) {
			try {
				String[] monthStrings = req.getParameterValues("months");
				System.out.println(monthStrings);
				String message = "Choose months: ";
				for (String month : monthStrings) {
					message += month + " ";
					System.out.println(month);
				}
				message += ".";
				List<Integer> months = new ArrayList<>();
				for (String month : monthStrings) {
					months.add(Integer.parseInt(month));
				}
				VideoDAO dao = new VideoDAO();
				List<Video> videos = dao.findByMonth(months);

				req.setAttribute("message", message);

				req.setAttribute("videos", videos);
			} catch (Exception e) {
				System.out.println(e);
				req.setAttribute("error", "An error occurred while fetching the videos.");
			}
		}
		req.getRequestDispatcher("/lab6/chooseMonth.jsp").forward(req, resp);
	}

	private void findUserID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String methodString = req.getMethod();
		if (methodString.equalsIgnoreCase("post")) {
			try {
				String username = req.getParameter("username");
				UserDAO dao = new UserDAO();
				User2 user = dao.findByID(username);
				List<Favorite> favorites = new ArrayList<>();
				if (user != null) {

					favorites = user.getFavorites();

				}
				req.setAttribute("user", user);
				req.setAttribute("favorites", favorites);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		req.getRequestDispatcher("/lab6/find-userID.jsp").forward(req, resp);
	}

	private void findVideoTitle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String methodString = req.getMethod();
		if (methodString.equalsIgnoreCase("post")) {
			try {
				String keyword = req.getParameter("keyword");
				VideoDAO dao = new VideoDAO();
				List<Video> videos = dao.findByTitle(keyword);
				req.setAttribute("videos", videos);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		req.getRequestDispatcher("/lab6/findVideoTitle.jsp").forward(req, resp);
	}

	private void findUserLikeVideo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String methodString = req.getMethod();
		if (methodString.equalsIgnoreCase("post")) {
			try {
				String videoId = req.getParameter("videoId");
				UserDAO dao = new UserDAO();
				List<User2> users = dao.findUserLikeVideo(videoId);
				req.setAttribute("users", users);
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
		req.getRequestDispatcher("/lab6/findUserLikeVideo.jsp").forward(req, resp);
	}

	private void findFavorite(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String methodString = req.getMethod();
		if (methodString.equalsIgnoreCase("post")) {
			try {
				Boolean favorite = Boolean.parseBoolean(req.getParameter("favorite"));
				VideoDAO dao = new VideoDAO();
				List<Video> list = dao.findFavorite(favorite);
				req.setAttribute("videos", list);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		req.getRequestDispatcher("/lab6/findFavorite.jsp").forward(req, resp);
	}

	private void listVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String methodString = req.getMethod();
		if (methodString.equalsIgnoreCase("post")) {
			try {
				Boolean favorite = Boolean.parseBoolean(req.getParameter("favorite"));
				VideoDAO dao = new VideoDAO();
				List<Video> list = dao.findFavorite(favorite);
				req.setAttribute("videos", list);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		req.getRequestDispatcher("/lab6/findFavorite.jsp").forward(req, resp);
	}

	private void favoriteCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String methodString = req.getMethod();
		if (methodString.equalsIgnoreCase("get")) {
			try {
				ReportDAO dao = new ReportDAO();
				List<Report> reports = dao.report();
				req.setAttribute("reports", reports);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		req.getRequestDispatcher("/lab6/favoriteCount.jsp").forward(req, resp);
	}

	private void fromTo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String methodString = req.getMethod();
		String from = req.getParameter("from");
		String to = req.getParameter("to");
		System.out.println(from);
		System.out.println(to);
		if (from.isBlank() || to.isBlank()) {
			req.setAttribute("error", "Please, Fill all field");
		} else if (methodString.equalsIgnoreCase("post")) {
			req.setAttribute("message", "From: " + from + "\nTo: " + to);
			try {
				VideoDAO dao = new VideoDAO();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust format as per your
																					// requirement
				Date fromDate = dateFormat.parse(from);
				Date toDate = dateFormat.parse(to);

				List<Video> videos = dao.findInRange(fromDate, toDate);
				req.setAttribute("videos", videos);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println("xuong day");
		req.getRequestDispatcher("/lab6/fromTo.jsp").forward(req, resp);
	}
}
