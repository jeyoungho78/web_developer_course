package com.example.spring.member.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.member.entity.MemberEntity;

@Repository("MemberDao")
public class MemberDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	private String nameSpaceName = "member.";
	
	public void memberInsert(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		this.sqlSession.insert(nameSpaceName + "memberInsert", map);
	}

	public List<MemberEntity> memberView(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		List<MemberEntity> list = this.sqlSession.selectList(nameSpaceName + "memberView", map);
		return list;
	}

}
