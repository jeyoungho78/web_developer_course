package com.example.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController{
	
	private String me;

	public void setMe(String me) {
		this.me = me;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting", "안녕");
		mv.addObject("me", me);
		mv.setViewName("hello");  // 이동하고자 하는 jsp명 
		
		return mv;
	}
	
}
