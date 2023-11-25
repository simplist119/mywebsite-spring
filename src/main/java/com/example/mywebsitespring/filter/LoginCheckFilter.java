package com.example.mywebsitespring.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/board"})
public class LoginCheckFilter implements Filter {

    public LoginCheckFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        System.out.println("getServletPath" + request.getServletPath());
        // 로그인이 되어 있다면
        if (session.getAttribute("id") != null) {
            System.out.println("1");
            chain.doFilter(request, response);
        }
        // 로그인이 안 되어 있다면
        System.out.println("2");
        response.sendRedirect("/login?toURL=" + request.getServletPath() + "?page=1");
    }

    public void destroy() {
    }
}
