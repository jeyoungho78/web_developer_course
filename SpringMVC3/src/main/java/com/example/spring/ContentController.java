package com.example.spring;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContentController {

	private static final Logger logger = LoggerFactory.getLogger(ContentController.class);
	
	@RequestMapping(value="/login.do")
	public String doLogin(
			@RequestParam(value="id") String id,
			@RequestParam(value="pw") String pw,
			HttpServletRequest request,
			Model model) {
		logger.info("login 시작");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		
		return "redirect:/web/resources/contentWrite.jsp";
	}
	
	/*@RequestMapping(value="/contentWrite.do")
	public String doContentWrite(
				HttpSession session
			) {
		logger.info("contentWrite 시작");
		
		logger.info("isLogin : ", session.getAttribute("isLogin"));
			
		return "/content/contentWrite";
	}
	*/
	
	@RequestMapping(value="/contentView.do")
	public String doContentView(
			@RequestParam MultiValueMap<String, Object>params,
			Model model) {
		logger.info("contentView 시작");
		logger.info("title : " + params.get("title"));
		logger.info("content : " + params.get("content"));
		logger.info("interest : " + params.get("interest").size());
		
		model.addAttribute("params", params);
		
		return "/content/contentView";
	}
	
}
