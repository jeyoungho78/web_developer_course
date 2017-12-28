package com.example.spring.common.error;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class CommonError {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonError.class);
	
	private final String VIEW_PATH_DIR = "/error/";
	
	@ExceptionHandler({Exception.class})
	public ModelAndView getCommonException(Exception e, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("errorMessage", e.getMessage());
		mv.setViewName(VIEW_PATH_DIR + "error");
		
		return mv;
	}
	
}
