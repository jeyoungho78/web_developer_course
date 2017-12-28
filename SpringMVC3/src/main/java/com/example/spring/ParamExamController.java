package com.example.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.spring.entity.Member;

@Controller
public class ParamExamController {
	
	private static final Logger logger = LoggerFactory.getLogger(ParamExamController.class);
	
	@RequestMapping(value="/paramExamPrint.do", method=RequestMethod.GET)
	public String paramExam(
			@ModelAttribute("mem") Member mem, Model model) {
		
		logger.info("id : " + mem.getId());
		logger.info("name : " + mem.getName());
		logger.info("email : " + mem.getEmail());
		logger.info("hobby.length : " + mem.getHobby().length);
		
		for(String hobby : mem.getHobby()) {
			logger.info("hobby : " + hobby);
		}
		
		return "/exam/paramExamPrint";
	}
	
}
