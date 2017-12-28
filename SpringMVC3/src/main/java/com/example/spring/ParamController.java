package com.example.spring;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.spring.entity.Member;
import com.example.spring.service.ParamService;

@Controller
public class ParamController {
	
	private static final Logger logger = LoggerFactory.getLogger(ParamController.class);
	
	@Autowired
	ParamService paramService;
	
	// POST 방식은 method 부분 지워서 사용
	@RequestMapping(value="/requestParam.do", method=RequestMethod.GET)
	public String paramTest01(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		logger.info("name : " + request.getParameter("name"));
		
		model.addAttribute("id", request.getParameter("id"));
		model.addAttribute("name", request.getParameter("name"));
		model.addAttribute("email", request.getParameter("email"));
		
		return "/param/requestParam";
	}
	
	@RequestMapping(value="/requestParam2.do")
	public String paramTest02(
			@RequestParam(value="id") String id,
			@RequestParam(value="name") String name,
			@RequestParam(value="email", required=false) String email,	
			@RequestParam(value="hobby", required=false) List<String> hobby,
			Model model) throws UnsupportedEncodingException {
		
		logger.info("name : " + id);
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("hobby", hobby);
		
		for(String one : hobby) {
			logger.info("hobby : " + one);
		}
		
		if(id != "") {
			return "/param/requestParam";
		} else {
			return "redirect:/resources/paramTest.html";	
		} 
	}
	
	@RequestMapping(value="/requestParam3.do")
	public String paramTest03(
			Member mem, 	
			Model model) throws UnsupportedEncodingException {
		
		logger.info("id : " + mem.getId());
		logger.info("name : " + mem.getName());
		logger.info("email : " + mem.getEmail());
		
		model.addAttribute("mem", mem);
		
		return "/param/requestParam3";	
	}
	
	@RequestMapping(value="/requestParam4.do")
	public String paramTest04(
			@ModelAttribute("mem") Member mem, 	
			Model model) throws UnsupportedEncodingException {
		
		logger.info("id : " + mem.getId());
		logger.info("name : " + mem.getName());
		logger.info("email : " + mem.getEmail());
		logger.info("hobby.length : " + mem.getHobby().length);
		
		for(String hobby : mem.getHobby()) {
			logger.info("hobby : " + hobby);
		}
		
		return "/param/requestParam3";	
	}
	
	@ModelAttribute("animal")
	public ArrayList<String> getAnimalList(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("강아지");
		list.add("소");
		list.add("고양이");
		
		return list;
	}
	
	@RequestMapping(value="/requestParam5.do")
	public String paramTest05(
			@RequestParam HashMap<String, Object> params, 
			@RequestParam(value="hobby", required=false) List<String> hobby,
			Model model) throws UnsupportedEncodingException {
		
		logger.info("id : " + params.get("id"));
		logger.info("name : " + params.get("name"));
		logger.info("email : " + params.get("email"));
		//logger.info("hobby : " + params.get("hobby"));
		model.addAttribute("hobby", hobby);
		
		model.addAttribute("params", params);
		
		return "/param/requestParam5";	
	}
	
	@RequestMapping(value="/requestParam6.do")
	public String paramTest06(
			@RequestParam MultiValueMap<String, Object> params,
			Model model) throws UnsupportedEncodingException {
		
		logger.info("id : " + params.get("id").get(0));
		logger.info("name : " + params.get("name").get(0));
		logger.info("email : " + params.get("email").get(0));
		logger.info("hobby : " + params.get("hobby").get(0));
		logger.info("hobby size : " + params.get("hobby").size());
		
		List<Object> hobbyList = params.get("hobby");
		for(int i = 0; i < hobbyList.size(); i++) {
			logger.info("hobby [" + i + "]:" + hobbyList.get(i));
		}
		
		model.addAttribute("params", params);
		
		return "/param/requestParam6";	
	}
	
	@RequestMapping(value="/requestParam7.do")
	public String paramTest07(
			Member mem,
			Model model) throws UnsupportedEncodingException {
		
		logger.info("id : " + mem.getId());
		logger.info("name : " + mem.getName());
		logger.info("email : " + mem.getEmail());
		logger.info("selAnimal : " + mem.getSelAnimal());
		
		model.addAttribute("mem", mem);
		
		return "/param/requestParam4";	
	}
	
	@ModelAttribute("animalMap")
	public Map<String, String> getAnimalMap(){
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("dog", "강아지");
		map.put("cow", "소");
		map.put("cat", "고양이");
		
		return map;
	}
	
	//
	@RequestMapping(value="/requestParam8.do")
	public String paramTest08(
			@RequestParam HashMap<String, Object> params,
			@RequestParam (value="hobby") List<String> hobby, 
			Model model) throws UnsupportedEncodingException {
		
		logger.info("id : " + params.get("id"));
		logger.info("name : " + params.get("name"));
		logger.info("email : " + params.get("email"));
		logger.info("hobby size : " + hobby.size());
		
		paramService.paramView(hobby);
		try {
			paramService.paramView(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("hobby", hobby);
		model.addAttribute("params", params);
		
		return "/param/requestParam8";	
	}
	
	@RequestMapping(value="ajaxFormSubmit.ajax")
	public @ResponseBody HashMap<String, String> ajaxFormSubmit(
			@RequestParam HashMap<String, String> map
 		  , @RequestParam(value="hobby") List<String> hobbyList){
		
		map.put("success", "false");
		
		for(String hobby : hobbyList) {
			if(hobby.equals("baseball")) {
				map.put("success", "true");
				break;
			}
		}
		
		return map;
	}
	
	@RequestMapping(value="fileUploadTest.do")
	public String fileUploadTest(
			MultipartHttpServletRequest request
		  , Model model) {
		
		String rootUploadDir = "c:"+ File.separator + "Upload";
		
		File dir = new File(rootUploadDir + File.separator + "testfile");
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		Iterator<String> iterator = request.getFileNames();
		
		int fileLoop = 0;
		String uploadFileName;
		MultipartFile mFile = null;
		String orgFileName = "";
		String sysFileName = "";
		
		ArrayList<String> list =  new ArrayList<String>();
		
		while(iterator.hasNext()) {
			fileLoop++;
			
			uploadFileName = iterator.next();
			mFile = request.getFile(uploadFileName);
			
			orgFileName = mFile.getOriginalFilename();
			
			if(orgFileName != null && !orgFileName.equals("")) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMDDHHmmss-" + fileLoop);
				Calendar calendar = Calendar.getInstance();
				sysFileName = simpleDateFormat.format(calendar.getTime());
				
				try {
					mFile.transferTo(new File(dir + File.separator + sysFileName));
					list.add("원본파일명:" + orgFileName + ", 시스템파일명:" + sysFileName);
				} catch (Exception e) {
					// TODO: handle exception
					list.add("파일올리는중 에러");
				}
			}
		}
		
		model.addAttribute("list", list);
		
		return "fileTest/fileResult";
	}
}
