package com.dao.board;

import java.util.*;
import java.math.BigDecimal;
import java.sql.*;

import com.common.board.paging.PagingLogic;
import com.common.connection.ConnectDB;
import com.entity.sample.SampleEntity;
import com.mvc.db.connection.IBatisDBConnector;

public class BoardDao {

	public int getBoardListSize() throws Exception{
		int rowCnt = 0;
		try {
			rowCnt = Integer.valueOf((IBatisDBConnector.getSqlMapInstance()).queryForObject("getBoardListSize").toString());			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return rowCnt;
	}
	
	public ArrayList getBoardList(HashMap<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		PagingLogic pl = null;
		ArrayList list = new ArrayList();
	
		try {
			pl = (PagingLogic)map.get("PagingLogic");
			
			int selectedPage    = Integer.valueOf(map.get("selectedPage").toString());
			map.put("contentStart", pl.getContentStart());
			map.put("contentEnd", pl.getContentEnd());
			
    		list = (ArrayList)(IBatisDBConnector.getSqlMapInstance()).queryForList("getBoardList", map);
			
    		// URL을 셋팅해주는 부분 
    		for(int i = 0; i < list.size(); i++) {
    			HashMap<String, Object> data = (HashMap<String, Object>)list.get(i);
    			data.put("BOARD_CONTENT_URL", pl.makeContentURL(Integer.valueOf(data.get("BOARD_NUM").toString()), selectedPage));
    			list.set(i, data);
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	public ArrayList viewBoardContent(HashMap<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		try {
			
    		list = (ArrayList)(IBatisDBConnector.getSqlMapInstance()).queryForList("viewBoardContent", map);
    		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	public void updateBoardClickCount(HashMap<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		try {
			(IBatisDBConnector.getSqlMapInstance()).update("updateBoardClickCount", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void writeBoardContent(HashMap<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		try {
			int newBoardNum = getNewBoardNum();
			map.put("newBoardNum", newBoardNum);
			
			(IBatisDBConnector.getSqlMapInstance()).insert("writeBoardContent", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getNewBoardNum() throws Exception{
		// TODO Auto-generated method stub
		int num = 0;
		try {
			num = Integer.valueOf((IBatisDBConnector.getSqlMapInstance()).queryForObject("getNewBoardNum").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return num;
	}
	
	/*public void writeBoardContent(HashMap<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		String sqlWhere = "";
	
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			
			String boardTitle 		= map.get("boardTitle").toString();
    		String boardWriter 	    = map.get("boardWriter").toString();
    		String boardContent 	= map.get("boardContent").toString();
			
			int newBoardNum = getNewBoardNum();
			
			sql = "INSERT INTO BOARD VALUES \n" + 
			      "(" + newBoardNum  + ",  '" +  
			    		boardTitle   + "', '" +  
			    		boardContent + "', '" +
			    	    boardWriter  + "', "  + 
			            0            + ", " + 
			    		"TO_CHAR(SYSDATE, 'YYYYMMDDHHMISS')" + ", '" + 
			            "N" + "')";
			System.out.println(sql);
			
			int result = stmt.executeUpdate(sql);
			if(result == 1){
				// 저장성공
				con.commit();
			} else {
				// 저장실패
				con.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		}
	}*/

	/*public int getNewBoardNum() throws Exception{
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		int num = 0;
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
		
			sql = "SELECT NVL(MAX(BOARD_NUM), 1) + 1 AS NEW_BOARD_NUM FROM BOARD";
			System.out.println(sql);
			 
			rs = stmt.executeQuery(sql);
			 
			while (rs.next()) {
				num = rs.getInt("NEW_BOARD_NUM");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		}
		
		return num;
	}*/
	
	public void updateBoardContent(HashMap<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		String sql = "";
		String sqlWhere = "";
	
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			
			int boardNum = Integer.valueOf(map.get("boardNum").toString());
			String boardTitle 		= map.get("boardTitle").toString();
    		String boardWriter 	    = map.get("boardWriter").toString();
    		String boardContent 	= map.get("boardContent").toString();
			
			sql = "UPDATE BOARD             						    \n" + 
					  "   SET BOARD_TITLE = '" + boardTitle + "'   		\n" +
					  "     , BOARD_WRITER = '" + boardWriter + "'   	\n" +
					  "     , BOARD_CONTENT = '" + boardContent + "'  	\n" +
					  " WHERE 1=1                 \n" +
					  "   AND BOARD_NUM = " + boardNum
					  ;
			System.out.println(sql);
			
			int result = stmt.executeUpdate(sql);
			if(result == 1){
				// 저장성공
				con.commit();
			} else {
				// 저장실패
				con.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		}
	}

	public void deleteBoardContent(HashMap<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		String sql = "";
		String sqlWhere = "";
	
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			
			int boardNum = Integer.valueOf(map.get("boardNum").toString());
			
			sql = "UPDATE BOARD             						\n" + 
					  "   SET DEL_YN = 'Y'  							\n" +
					  " WHERE 1=1                 \n" +
					  "   AND BOARD_NUM = " + boardNum
					  ;
			System.out.println(sql);
			
			int result = stmt.executeUpdate(sql);
			if(result == 1){
				// 저장성공
				con.commit();
			} else {
				// 저장실패
				con.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		}
	}

	
	
	public int getMaxBoardNum() throws Exception{
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		int num = 0;
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
		
			sql = "SELECT NVL(MAX(BOARD_NUM), 1) AS MAX_BOARD_NUM FROM BOARD";
			System.out.println(sql);
			 
			rs = stmt.executeQuery(sql);
			 
			while (rs.next()) {
				num = rs.getInt("MAX_BOARD_NUM");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		}
		
		return num;
	}
	
	public int getNewFileNum() throws Exception{
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		int num = 0;
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
		
			sql = "SELECT NVL(MAX(FILE_NUM), 1) + 1 AS NEW_FILE_NUM FROM BOARD_FILE";
			System.out.println(sql);
			 
			rs = stmt.executeQuery(sql);
			 
			while (rs.next()) {
				num = rs.getInt("NEW_FILE_NUM");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		}
		
		return num;
	}
	
	public void uploadFiles(HashMap<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		String sqlWhere = "";
	
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			
			ArrayList fileList 	= (ArrayList)map.get("fileList");
			
			int maxBoardNum = getMaxBoardNum();
			int newFileNum = 0;
			String filename = "";
			String origfilename = "";
			String renamefilename = "";
			for(int i = 0; i < fileList.size(); i++) {
				
				newFileNum = getNewFileNum();
				
				HashMap<String, String> fileMap = (HashMap<String, String>)fileList.get(i);
				filename = (String)fileMap.get("filename");
				origfilename = (String)fileMap.get("origfilename");
				//renamefilename = (String)fileMap.get("renamefilename");
				
				sql = "INSERT INTO BOARD_FILE VALUES \n" + 
				      "(" + newFileNum  + ",  '" +  
				      	    maxBoardNum   + "', '" +  
				            filename + "', '" +
				            origfilename  + "', "  + 
				         //   renamefilename  + "', "  + 
				            "TO_CHAR(SYSDATE, 'YYYYMMDDHHMISS')" + ", '" + 
				            "N" + "')";
				System.out.println(sql);
				
				int result = stmt.executeUpdate(sql);
				if(result == 1){
					// 저장성공
					con.commit();
				} else {
					// 저장실패
					con.rollback();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		}
	}

	public HashMap<String, String> getdownloadFileInfo(HashMap<String, Object> map) throws Exception{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		HashMap<String, String> fileMap = null;
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
		
			int fileNum = Integer.valueOf(map.get("fileNum").toString());
			
			sql = "SELECT SYS_NM          \n" + 
				  "     , ORG_NM          \n" + 
				  "  FROM BOARD_FILE      \n" + 
				  " WHERE 1=1             \n" + 
				  "   AND FILE_NUM = " + fileNum;
			System.out.println(sql);
			 
			rs = stmt.executeQuery(sql);
			 
			while (rs.next()) {
				fileMap.put("SYS_NM", rs.getString("SYS_NM"));
				fileMap.put("ORG_NM", rs.getString("ORG_NM"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		}
		
		return fileMap;
	}
}
