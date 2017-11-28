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
	
	public int getMaxBoardNum() throws Exception{
		int num = 0;
		try {
			num = Integer.valueOf((IBatisDBConnector.getSqlMapInstance()).queryForObject("getMaxBoardNum").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public int getNewFileNum() throws Exception{
		int num = 0;
		try {
			num = Integer.valueOf((IBatisDBConnector.getSqlMapInstance()).queryForObject("getNewFileNum").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public void uploadFiles(HashMap<String, Object> map) throws Exception{
		try {
			
			ArrayList fileList 	= (ArrayList)map.get("fileList");
			
			int maxBoardNum = getMaxBoardNum();
			int newFileNum = 0;
			for(int i = 0; i < fileList.size(); i++) {
				
				newFileNum = getNewFileNum();
				
				HashMap<String, Object> fileMap = (HashMap<String, Object>)fileList.get(i);
				fileMap.put("newFileNum", newFileNum);
				fileMap.put("maxBoardNum", maxBoardNum);
				
			    (IBatisDBConnector.getSqlMapInstance()).update("uploadFiles", fileMap);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public HashMap<String, String> getdownloadFileInfo(HashMap<String, Object> map) throws Exception{
		HashMap<String, String> fileMap = null;
		try {
			fileMap = (HashMap<String, String>)(IBatisDBConnector.getSqlMapInstance()).queryForList("getdownloadFileInfo", map);	
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return fileMap;
	}
	
	public void updateBoardContent(HashMap<String, Object> map) throws Exception{
		try {
			(IBatisDBConnector.getSqlMapInstance()).update("updateBoardContent", map);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void deleteBoardContent(HashMap<String, Object> map) throws Exception{
		try {
			(IBatisDBConnector.getSqlMapInstance()).update("deleteBoardContent", map);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
