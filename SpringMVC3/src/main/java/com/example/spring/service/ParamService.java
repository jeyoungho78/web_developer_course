package com.example.spring.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ParamService {
	
	private static final Logger logger = LoggerFactory.getLogger(ParamService.class);
	
	public void paramView(HashMap<String, Object> param) throws Exception {
		logger.debug("paramView() 함수");
		throw new Exception();
	}
	
	public void paramView(List<String> param) {
		logger.debug("paramView() 함수");
	}
}
