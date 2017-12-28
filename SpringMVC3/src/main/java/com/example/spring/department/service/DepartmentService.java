package com.example.spring.department.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.department.controller.DepartmentController;
import com.example.spring.department.dao.DepartmentDao;

@Service
public class DepartmentService {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
		
	public List departmentList(HashMap<String, String> map) {
		List<HashMap<String, Object>> list = departmentDao.departmentList(map);
		return list;
	}
	
	public void departmentInsert(HashMap<String, String> map) {
		departmentDao.departmentInsert(map);
	}

	public void departmentUpdate(HashMap<String, String> map) {
		departmentDao.departmentUpdate(map);
		
	}	
	
	public void fileUpload(HashMap<String, Object>map, List<MultipartFile> fileList) {		
		String rootPath = "c:" + File.separator + "Upload";
		String uploadPath = rootPath + File.separator + "testfile";
		int fileLoop = 0;
		String orgFileName = "";
		String sysFileName = "";
		
		if(fileList != null && fileList.size() > 0) {
			
			Calendar calendar = Calendar.getInstance();
			
			for(MultipartFile file : fileList) {				
				SimpleDateFormat simpleDateFormat
					= new SimpleDateFormat("yyyyMMddHHmmss-" + fileLoop);				
				orgFileName = file.getOriginalFilename();
				
				if(orgFileName != null && !orgFileName.equals("")) {
					sysFileName = simpleDateFormat.format(calendar.getTime());
					
					try {
						file.transferTo(new File(uploadPath + File.separator + sysFileName));
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					fileLoop++;
					
					logger.debug("원본파일명:" + orgFileName + ", 시스템저장파일명:" + sysFileName);
					
				}//if
			}//for		
		}//if
		
	}
}
