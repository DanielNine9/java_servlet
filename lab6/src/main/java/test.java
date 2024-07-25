import java.util.List;

import bean.Report;
import dao.ReportDAO;

public class test {
	public static void main(String[] args) {
		ReportDAO dao = new ReportDAO();
		List<Report> reports = dao.favoriteByYear(2024);
		System.out.println(reports.size());
		
	}

}
