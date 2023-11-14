package com.example.mywebsitespring.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

    public CharacterEncodingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8"); 		// 넘어온 파라미터의 인코딩 설정을 UTF-8로 설정
		response.setCharacterEncoding("utf-8");    	// 서블릿을 통해 생성되는 HTML 파일의 인코딩을 UTF-8로 설정
		response.setContentType("text/html; charset=utf-8");   // HTML이 UTF-8 형식이라는 것을 브라우저에게 전달
//		TODO : 톰캣 실행시 왜 4번 돌아가는지?
		System.out.println("---encodingfilter---");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
