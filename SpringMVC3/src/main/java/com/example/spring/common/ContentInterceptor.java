package com.example.spring.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ContentInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(ContentInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("ContentInterceptor > preHandle ÁøÀÔ");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		logger.info("id : " + id);
		
		if(id == null) {
			response.sendRedirect("/web/resources/login.jsp");
			return false;
		} 
		
		return true;
	}
	

}
