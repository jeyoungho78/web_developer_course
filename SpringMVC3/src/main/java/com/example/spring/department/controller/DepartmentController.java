package com.example.spring.department.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.department.service.DepartmentService;

@Controller
public class DepartmentController {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	private String PRE_VIEW_PATH = "/department/";

	
	@RequestMapping(value="departmentList.do")
	public ModelAndView departmentList(HttpServletRequest request) {
		HashMap<String, String> map = new HashMap<String, String>();
		//ModelAndView mv = departmentService.departmentList(map);
		map.put("deptCode", "10");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", departmentService.departmentList(map));
		mv.setViewName(PRE_VIEW_PATH + "departmentList");
		
		return mv;
	}
	
	@RequestMapping(value="departmentInsert.do")
	public ModelAndView departmentInsert(HttpServletRequest request) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("deptCode", "98");
		map.put("deptName", "테스트학과");
		map.put("deptEname", "dept of test");
		
		departmentService.departmentInsert(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName(PRE_VIEW_PATH + "insertConfirm");
		
		return mv;
	}
	
	@RequestMapping(value="departmentUpdate.do")
	public ModelAndView departmentUpdate(HttpServletRequest request) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("deptCode", "98");
		map.put("deptName", "테스트학과2");
		map.put("deptEname", "dept of test2");
		
		departmentService.departmentUpdate(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName(PRE_VIEW_PATH + "insertConfirm");
		
		return mv;
	}
	
	@RequestMapping(value="fileUpload.do")
	public String fileUpload(
	         @RequestParam HashMap<String, Object> map
	         ,@RequestParam(value="hobby") List<String> hobbyList
	          ,@RequestParam(value="file1") List<MultipartFile> fileList
	           ,MultipartHttpServletRequest requset){
	      
	      logger.debug("서버로 전달된 값 : " +  map);
	      for(String one: hobbyList) {
	         logger.debug("서버로 취미결과 : " +  one);
	      }
	      
	      departmentService.fileUpload(map, fileList);
	      
	      return "fileTest/fileResult2";
	 }
	
	@RequestMapping(value="errorTest.do")
	public String errorTest(HttpServletRequest request, Model model) throws Exception{
		
		logger.debug("errorTest.do 진입");
		
		if(1==1) {
			throw new Exception("errorTest.do");
		}
		
		
		return null;
	}
}
