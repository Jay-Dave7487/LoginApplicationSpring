package com.loginapplication.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class SessionFilter implements javax.servlet.Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        boolean isLoggedIn = session != null && session.getAttribute("userId") != null;

        // Check if the user is logged in
        if (!isLoggedIn && !request.getRequestURI().endsWith("login")) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) {
        // Initialization code
    }

    @Override
    public void destroy() {
        // Cleanup code
    }

	@Override
	public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response,
			javax.servlet.FilterChain chain) throws IOException, javax.servlet.ServletException {
		// TODO Auto-generated method stub
		
	}
}
