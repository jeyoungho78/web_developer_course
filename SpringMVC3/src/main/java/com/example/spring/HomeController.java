package com.example.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.beantest.SmsSender;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	SmsSender smsSender;
	
	/*public void setSmsSender(SmsSender smsSender) {
		this.smsSender = smsSender;
	}*/
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("smsSender boolean value: " + smsSender.isValue());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public ModelAndView testHome(HttpServletRequest req,  HttpServletResponse res) {
	
		ModelAndView mv = new ModelAndView();
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		
		mv.addObject("serverTime", "/test.do :" + formattedDate );
		mv.setViewName("home");
		
		return mv;
	}
	
	/*@RequestMapping(value = "/inputID.do", method = RequestMethod.GET)
	public ModelAndView inputID(HttpServletRequest req,  HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("inputID");
		
		return mv;
	}*/
	
	@RequestMapping(value = "/inputID.do", method = RequestMethod.GET)
	public ModelAndView inputID(HttpServletRequest req,  HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		
		String value = (String)req.getParameter("id");		
		System.out.println("value : " + value);
		
		if(value != null) {
			mv.addObject("id", value);
		}
		
		mv.setViewName("inputID");
		
		return mv;
	}
	
}
