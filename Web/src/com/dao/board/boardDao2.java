package com.dao.board;

import java.util.*;
import java.sql.*;

import com.common.board.paging.PagingLogic;
import com.common.connection.ConnectDB;

public class boardDao2 {

	public int getBoardListSize() throws Exception{
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		int rowCnt = 0;
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
		
			sql = "SELECT COUNT(*) AS ROWCNT FROM BOARD WHERE DEL_YN = 'N'";
			System.out.println(sql);
			 
			rs = stmt.executeQuery(sql);
			 
			while (rs.next()) {
			   rowCnt = rs.getInt("ROWCNT");
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
		
		return rowCnt;
	}
	
	public ArrayList getBoardList(HashMap<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		String sqlWhere = "";
		PagingLogic pl = null;
		ArrayList list = new ArrayList();
	
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			
			pl = (PagingLogic)map.get("PagingLogic");
			
			int selectedPage    = Integer.valueOf(map.get("selectedPage").toString());
			String field 		= map.get("field").toString();
    		String searchWord 	= map.get("searchWord").toString();
    		int contentStart    = pl.getContentStart();
			int contentEnd      = pl.getContentEnd();
 			
    		sqlWhere = "WHERE 1=1       \n" + "  AND DEL_YN = 'N'"; 
	   		if (!field.equals("") || !searchWord.equals("")){
	   			sqlWhere +=  "  AND " + field + " LIKE '%" + searchWord + "%'";
	   		} 
    		
			sql = "SELECT X.*                             \n" +
  				  "  FROM(SELECT ROWNUM AS RNUM           \n" +
  				  "            , BOARD_NUM                \n" +
  				  "             , BOARD_TITLE             \n" +
  				  "             , BOARD_CONTENT           \n" +
  				  "             , BOARD_WRITER            \n" +
  				  "             , BOARD_CLICK_CNT         \n" +
  				  "             , CREATE_DATE             \n" +
  				  "             , DEL_YN           		  \n" +
  				  "         FROM (SELECT * FROM BOARD     \n" +
  				  " 			      " + sqlWhere +     "\n" +
  				  " 			ORDER BY BOARD_NUM DESC)  \n" + 
  				  "        WHERE 1=1) X \n" +
  				  "  WHERE 1=1 \n" +
  				  "    AND RNUM >= " + contentStart + " AND RNUM <= " + contentEnd
  				    ;
  		    System.out.println(sql);
  		    rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				HashMap<String, String> data = new HashMap<String, String>();
				data.put("RNUM", 			  String.valueOf(rs.getInt("RNUM")));
				data.put("BOARD_NUM", 		  String.valueOf(rs.getInt("BOARD_NUM")));
				data.put("BOARD_TITLE", 	  rs.getString("BOARD_TITLE"));
				data.put("BOARD_CONTENT", 	  rs.getString("BOARD_CONTENT"));
				data.put("BOARD_WRITER", 	  rs.getString("BOARD_WRITER"));
				data.put("BOARD_CLICK_CNT",   String.valueOf(rs.getInt("BOARD_CLICK_CNT")));
				data.put("CREATE_DATE", 	  rs.getString("CREATE_DATE"));
				data.put("DEL_YN", 			  rs.getString("DEL_YN"));
				data.put("BOARD_CONTENT_URL", pl.makeContentURL(rs.getInt("BOARD_NUM"), selectedPage));
				list.add(data);
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
		
		return list;
	}
	
	public ArrayList viewBoardContent(HashMap<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		String sqlWhere = "";
		ArrayList list = new ArrayList();
	
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			
			int boardNum = Integer.valueOf(map.get("boardNum").toString());
			
			if (boardNum != 0){
				 sqlWhere = " WHERE 1=1              				\n" + 
						    "   AND B.BOARD_NUM = F.BOARD_NUM(+)    \n" + 
						    "   AND B.BOARD_NUM = " + boardNum; 
			 }
			
			 sql = "SELECT B.BOARD_NUM AS BOARD_NUM         		\n" +     
				   "     , B.BOARD_TITLE AS BOARD_TITLE      		\n" +   
				   "     , B.BOARD_CONTENT AS BOARD_CONTENT     	\n" +  
				   "     , B.BOARD_WRITER AS BOARD_WRITER     		\n" +   
				   "     , B.BOARD_CLICK_CNT AS BOARD_CLICK_CNT  	\n" + 
				   "     , B.CREATE_DATE AS CREATE_DATE      		\n" +   
				   "     , B.DEL_YN AS DEL_YN          				\n" + 
				   "     , F.FILE_NUM AS FILE_NUM         			\n" +
				   "     , F.SYS_NM AS SYS_NM         			    \n" +
				   "     , F.ORG_NM AS ORG_NM           			\n" + 
				   "  FROM BOARD B           						\n" + 
				   "     , BOARD_FILE F           					\n" + 
				   sqlWhere;

  		    System.out.println(sql);
  		    rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				HashMap<String, String> data = new HashMap<String, String>();
				data.put("BOARD_TITLE", 		  rs.getString("BOARD_TITLE"));
				data.put("BOARD_CONTENT", 		  rs.getString("BOARD_CONTENT"));
				data.put("BOARD_WRITER", 		  rs.getString("BOARD_WRITER"));
				data.put("BOARD_CLICK_CNT",       String.valueOf(rs.getInt("BOARD_CLICK_CNT")));
				data.put("CREATE_DATE", 		  rs.getString("CREATE_DATE"));
				data.put("DEL_YN", 		          rs.getString("DEL_YN"));
				data.put("FILE_NUM", 		      rs.getString("FILE_NUM"));
				data.put("SYS_NM", 		          rs.getString("SYS_NM"));
				data.put("ORG_NM", 		          rs.getString("ORG_NM"));	
				list.add(data);
			}
			
			sql = "UPDATE BOARD             						    \n" + 
					  "   SET BOARD_CLICK_CNT = BOARD_CLICK_CNT + 1     \n" +
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
		
		return list;
	}

	public void writeBoardContent(HashMap<String, Object> map) throws Exception{
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
	}

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

	public int getNewBoardNum() throws Exception{
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
