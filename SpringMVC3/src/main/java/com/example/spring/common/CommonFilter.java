package com.example.spring.common;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

public class CommonFilter extends GenericFilterBean {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonFilter.class);

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		logger.info(">>>>>>> 필터진입");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)arg0;
		//HttpServletResponse httpServletResponse = (HttpServletResponse)arg1; 
		
		logger.info("요청url:" + httpServletRequest.getRequestURL());
		arg2.doFilter(arg0, arg1);
		logger.info(">>>>>>> 필터종료");
		
	}
	
	
}
