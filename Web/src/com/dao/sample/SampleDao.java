package com.dao.sample;

import java.sql.*;
import java.util.*;

import com.common.connection.ConnectDB;
import com.entity.sample.SampleEntity;
import com.mvc.db.connection.IBatisDBConnector;

public class SampleDao {

	public ArrayList getSampleList(SampleEntity sampleEntity) {
		// 조회에 해당되는 모델 (데이터)처리 - 데이터베이스에서 해당되는 데이터를 조회하여 리턴 
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList list = new ArrayList();
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			
			sql = "SELECT DEPT_CODE AS deptCode, DEPT_NAME AS deptName FROM DEPARTMENT"
				+ " WHERE DEPT_CODE = " + sampleEntity.getDeptCode();
			System.out.println("sql : " + sql);
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				SampleEntity se = new SampleEntity();
				se.setDeptCode(rs.getString("deptCode"));
				se.setDeptName(rs.getString("deptName"));
				list.add(se);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList getSampleListIBatis(SampleEntity sampleEntity) {
		ArrayList<SampleEntity> list = new ArrayList<SampleEntity>();
		
		try {
			list = (ArrayList<SampleEntity>)(IBatisDBConnector.getSqlMapInstance()).queryForList("getDepartmentList", sampleEntity);
			//System.out.println("list.size() : " + list.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public ArrayList<HashMap<String, Object>> getSampleListIBatisMap(HashMap<String, String> map) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		try {
			list = (ArrayList<HashMap<String, Object>>)(IBatisDBConnector.getSqlMapInstance()).queryForList("getDepartmentList", map);
			//System.out.println("list.size() : " + list.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public ArrayList getSampleList(HashMap<String, String> sampleMap) {
		// 조회에 해당되는 모델 (데이터)처리 - 데이터베이스에서 해당되는 데이터를 조회하여 리턴 
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList list = new ArrayList();
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			
			sql = "SELECT DEPT_CODE AS deptCode, DEPT_NAME AS deptName FROM DEPARTMENT"
				+ " WHERE DEPT_CODE = " + (String)sampleMap.get("deptCode");
			System.out.println("sql : " + sql);
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				/*SampleEntity se = new SampleEntity();
				se.setDeptCode(rs.getString("deptCode"));
				se.setDeptName(rs.getString("deptName"));
				list.add(se);
				*/
				HashMap<String, String> data = new HashMap<String, String>();
				data.put("deptCode", rs.getString("deptCode"));
				data.put("deptName", rs.getString("deptName"));
				
				list.add(data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList getSampleAllList() {
		// 조회에 해당되는 모델 (데이터)처리 - 데이터베이스에서 해당되는 데이터를 조회하여 리턴 
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList list = new ArrayList();
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			
			sql = "SELECT DEPT_CODE AS deptCode, DEPT_NAME AS deptName FROM DEPARTMENT";
			System.out.println("sql : " + sql);
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				HashMap<String, String> data = new HashMap<String, String>();
				data.put("deptCode", rs.getString("deptCode"));
				data.put("deptName", rs.getString("deptName"));
				
				list.add(data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void insertSampleMap(HashMap<String, String> sampleMap) {
		// 입력에 해당되는 모델 (데이터)처리 - 데이터베이스에서 해당되는 데이터를 입력처리
		Connection con = null;
		Statement stmt = null;
		String sql = "";
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			
			sql = "INSERT INTO DEPARTMENT VALUES("
				+ (String)sampleMap.get("deptCode") 
				+ ", '" + (String)sampleMap.get("deptName")  + "'"
				+ ", '" + (String)sampleMap.get("deptEname") + "'"
				+ ", TO_CHAR(SYSDATE, 'YYYY/MM/DD'))";
			System.out.println("sql : " + sql);
			int result = stmt.executeUpdate(sql);
			if(result == 1) {
				con.commit();
			} else {
				con.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public int sampleInsertEnd(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		int retVal = 0;
		try { 
			retVal = (Integer)(IBatisDBConnector.getSqlMapInstance()).update("sampleInsertEnd", map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return retVal;
	}
}
