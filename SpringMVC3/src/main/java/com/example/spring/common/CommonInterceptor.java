package com.example.spring.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

	//컨트롤러가 실행되기 전에 수행되는 코드
	//리턴값이 true : 요청된 컨트롤러 수행
	//리턴값이 false : 요청된 컨트롤러를 수행하지 않고 종료
	//이곳에서 공통적으로 컨트롤러가 수행되기 전에 필수적으로 확인될 코드가 들어간다. 예: 로그인여부 
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("CommonInterceptor preHandle 진입");
		
		return true;
	}

	//뷰(jsp) 이동 바로전에 실행
	//컨트롤러에서 에러가 발생시에는 실행되지 않음.
	//request.setAttribute("",) 이런 값들이 많이 있을 때 사용 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("CommonInterceptor postHandle 진입");
		
		//modelAndView.addObject("endData", "postHandle Data");
		
		request.setAttribute("endData", "postHandle Data");
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		logger.info("CommonInterceptor afterCompletion 진입");
		
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	
}
