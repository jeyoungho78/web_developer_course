package com.example.spring.member.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.ParamController;
import com.example.spring.entity.Member;
import com.example.spring.member.entity.MemberEntity;
import com.example.spring.member.service.MemberService;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class); 
	
	@Autowired
	private MemberService memberService;
	
	private String PRE_VIEW_PATH = "/member/";
	
	@RequestMapping(value="memberInsert.do")
	public ModelAndView memberInsert(@RequestParam MultiValueMap<String, Object> params) {
		logger.info("id : " + params.get("id").get(0));
		logger.info("name : " + params.get("name").get(0));
		logger.info("email : " + params.get("email").get(0));
		logger.info("hobbyList : " + params.get("hobbyList"));
		logger.info("animal : " + params.get("animal").get(0));
		logger.info("gender : " + params.get("gender").get(0));
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", 			params.get("id").get(0));
		map.put("name", 		params.get("name").get(0));
		map.put("email", 		params.get("email").get(0));
		map.put("hobbyList", 	params.get("hobbyList"));
		map.put("animal", 		params.get("animal").get(0));
		map.put("gender", 		Integer.valueOf(params.get("gender").get(0).toString()));
		
		memberService.memberInsert(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName(PRE_VIEW_PATH + "memberEdit");
		
		return mv;
	}
	
	@RequestMapping(value="memberView.do")
	public String memberView(
			@ModelAttribute("member") MemberEntity member, 	
			Model model) {
		logger.info("memberView ¡¯¿‘");
		logger.info("id : " + member.getId());
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		/*HashMap<String, Object> map = new HashMap<String, Object>();
		//map.put("id", member.getId());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", memberService.memberView(map));
		mv.setViewName(PRE_VIEW_PATH + "memberView");*/
		
		model.addAttribute("member", memberService.memberView(map));
		
		return PRE_VIEW_PATH + "memberView";
	}
	
	@RequestMapping(value="memberUpate.do")
	public ModelAndView memberUpate(HttpServletRequest request) {
		return null;
	}
}
