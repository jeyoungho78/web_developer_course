package com.example.spring.member.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.member.controller.MemberController;
import com.example.spring.member.dao.MemberDao;
import com.example.spring.member.entity.MemberEntity;

@Service
public class MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class); 
	
	@Autowired
	private MemberDao memberDao;
	
	public void memberInsert(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		List<Object> hobbyList = (List<Object>)map.get("hobbyList");
		
		logger.info("hobbyList size : " + hobbyList.size());
		
		String strHobby = "";
		for(Object hobby : hobbyList) {
			logger.info("hobby : " + (String)hobby);
			strHobby += (String)hobby + "^";
		}
		
		logger.info("strHobby : " + strHobby);
		
		map.put("hobby", strHobby);
		
		memberDao.memberInsert(map);
	}

	public List<MemberEntity> memberView(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		List<MemberEntity> list = memberDao.memberView(map);
		return list;
	}

}
