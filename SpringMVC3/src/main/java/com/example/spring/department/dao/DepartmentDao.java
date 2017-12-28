package com.example.spring.department.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("departmentDao")
public class DepartmentDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	private String nameSpaceName = "department.";
	
	public List<HashMap<String, Object>> departmentList(HashMap<String, String> map){
		
		List<HashMap<String, Object>> list 
		= this.sqlSession.selectList(nameSpaceName + "departmentList", map);
		
		return list;
	}

	public void departmentInsert(HashMap<String, String> map) {
		this.sqlSession.insert(nameSpaceName + "departmentInsert", map);
	}

	public void departmentUpdate(HashMap<String, String> map) {
		this.sqlSession.insert(nameSpaceName + "departmentUpdate", map);
	}
	
}
