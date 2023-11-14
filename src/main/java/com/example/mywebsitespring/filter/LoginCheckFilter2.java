//package com.example.mywebsitespring.filter;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//public class LoginCheckFilter2 implements Filter{
//
//    private static final String[] whitelist = {"/", "/index", "/logincontroller", "/css/*"};
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("----필터링-----");
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        System.out.println("로그인체크");
//        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
//        System.out.println(session.getAttribute("id"));
//        System.out.println(session.getAttribute("id2"));
//        if(session.getAttribute("id") != null) {
//            System.out.println("로그인 되어 있음");
//
//            doFilter(servletRequest, servletResponse, filterChain);
//        }
//        System.out.println("로그인 안 되어 있음");
//        ((HttpServletResponse)servletResponse).sendRedirect("/logincontroller");
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
