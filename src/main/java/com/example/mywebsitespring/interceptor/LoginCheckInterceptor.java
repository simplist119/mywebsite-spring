//package com.example.mywebsitespring.interceptor;
//
//
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        if(session.getAttribute("id") != null){
//            System.out.println("로그인되어있다.");
//            System.out.println("prehandleb");
////            TODO : 이런것들은 매서드반환타입 string 으로 바꾸면 안되나? response.sendredirect 하기싫은데
//            response.sendRedirect("/studyboard");
//            return false;
//        }
//        System.out.println("로그인 안 되어 있다");
//        System.out.println("prehandlea");
//        response.sendRedirect("loginForm");
//;
//        return true;
////        return super.preHandle(request, response, handler);
//    }
//}
