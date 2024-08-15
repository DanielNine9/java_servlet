package com.poly.fiter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionExpirationFilter implements Filter
{
	@Override
    public void init(FilterConfig filterConfig) throws ServletException
	{
        // Không cần thiết phải cài đặt gì trong phương thức này
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false); // Lấy session hiện tại, nếu không tồn tại thì trả về null

        // Kiểm tra nếu session tồn tại và đã hết hạn
        if (session != null && isSessionExpired(session)) 
        {
            // Chuyển hướng người dùng đến trang đăng nhập
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/views/login.jsp");
            System.out.print("test het session");
            System.out.print(httpRequest.getContextPath());
            return;
        }

        // Tiếp tục chuỗi filter
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Không cần thiết phải cài đặt gì trong phương thức này
    }

    // Hàm này để kiểm tra xem session có hết hạn chưa
    private boolean isSessionExpired(HttpSession session) 
    {
    	long lastAccessedTime = session.getLastAccessedTime(); // Lấy thời gian cuối cùng mà session được truy cập
        long currentTime = System.currentTimeMillis(); // Lấy thời gian hiện tại
        int maxInactiveInterval = 60; // Thiết lập thời gian hết hạn của session là 30 giây
        long elapsedTimeInSeconds = (currentTime - lastAccessedTime) / 1000; // Tính thời gian đã trôi qua
        return elapsedTimeInSeconds > maxInactiveInterval;
    }

}


