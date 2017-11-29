package com.service.board;

import java.util.*;
import java.io.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.common.board.paging.PagingData;
import com.common.board.paging.PagingLogic;
import com.common.board.util.boardUtil;
import com.dao.board.BoardDao;
import com.oreilly.servlet.MultipartRequest;

public class BoardService {
	PagingData pd;
	PagingLogic pl;
	
	
	/**
	 * Desc : �Խù� ���� ��ȯ �Լ�
	 * @Method Name : getBoardListSize
	 * @return
	 */
	public int getBoardListSize() {
		int rowCnt = 0;
		try {
			BoardDao bd = new BoardDao();
			rowCnt = bd.getBoardListSize();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCnt;
	}
	
	/**
	 * Desc : �Խù� ��� ��ȯ �Լ� 
	 * @Method Name : getBoardList
	 * @param map
	 * @return
	 */
	public HashMap<String, Object> getBoardList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> boardListMap = null;
		
		try {
			BoardDao bd = new BoardDao();
			int rowCnt = bd.getBoardListSize();
			System.out.println("rowCnt : " + rowCnt);
			
			pd = new PagingData();
			pd.setTotalContentCount(rowCnt);
			pd.setPerPageContentCount(Integer.valueOf(map.get("perPageContentCount").toString()));
			pd.setPerPageViewPageCount(Integer.valueOf(map.get("perPageViewPageCount").toString()));
			pd.setSelectedPage(Integer.valueOf(map.get("selectedPage").toString()));
			
			pl = new PagingLogic(pd);			
			map.put("PagingLogic", pl);
			
			boardListMap = new HashMap<String, Object>();
			boardListMap.put("boardContentList", bd.getBoardList(map));
			boardListMap.put("pagingInfo", getPagingInfo(map)); 
			boardListMap.put("pagingList", getPaging(map));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return boardListMap;
	}

	/**
	 * Desc : �Խù� ����¡�� ���� ���� ��ȯ �Լ� 
	 *       (��ü ������ ��, ǥ�� ������ ���� ��ȣ, ǥ�� ������ ����ȣ, ���������� ��ȣ, �̵� ȭ��ǥ url�ּ� ��)
	 * @Method Name : getPagingInfo
	 * @param map
	 * @return
	 */
	private HashMap<String, Object> getPagingInfo(HashMap<String, Object> map) {		
		// TODO Auto-generated method stub
		int totalPageCount     = pl.getTotalPageCount();
        int underViewPageStart = pl.getUnderViewPageStart();
		int underViewPageEnd   = pl.getUnderViewPageEnd();
		int selectedPage 	   = pl.getPagingData().getSelectedPage();
		
		HashMap<String, Object> pagingInfoMap = new HashMap<String, Object>();
		pagingInfoMap.put("totalPageCount", totalPageCount);
		pagingInfoMap.put("underViewPageStart", underViewPageStart);
		pagingInfoMap.put("underViewPageEnd", underViewPageEnd);
		pagingInfoMap.put("selectedPage", selectedPage);
		pagingInfoMap.put("prePagingURL", pl.makePageURL(underViewPageStart - 1));
		pagingInfoMap.put("nextPagingURL", pl.makePageURL(underViewPageEnd + 1));
		
		return pagingInfoMap;
	}
	
	/**
	 * Desc : �Խù� ����¡ ���� ��ȯ �Լ� 
	 * 		  (ǥ�� ������ ��ȣ �� url)
	 * @Method Name : getPaging
	 * @param map
	 * @return
	 */
	private ArrayList getPaging(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		ArrayList pagingList = new ArrayList();
		
		int totalPageCount     = pl.getTotalPageCount();
        int underViewPageStart = pl.getUnderViewPageStart();
		int underViewPageEnd   = pl.getUnderViewPageEnd();
		
		for(int pageNum = underViewPageStart; pageNum <= underViewPageEnd; pageNum++){
			HashMap<String, Object> pagingData = new HashMap<String, Object>();
			pagingData.put("pageNum", pageNum);
			pagingData.put("pageNumURL", pl.makePageURL(pageNum));
			pagingList.add(pagingData);
		}
		
		return pagingList;
	}

	/**
	 * Desc : �Խù� ���� ��ȯ �Լ�
	 * @Method Name : viewBoardContent
	 * @param map
	 * @return
	 */
	public HashMap<String, Object> viewBoardContent(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> boardViewMap = null;
		
		try {
			BoardDao bd = new BoardDao();			
			boardViewMap = new HashMap<String, Object>();
			boardViewMap.put("boardContentView", bd.viewBoardContent(map));
			bd.updateBoardClickCount(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return boardViewMap;
	}

	/**
	 * Desc : ���� �ٿ�ε� �Լ� 
	 * @Method Name : downloadFile
	 * @param map
	 */
	public void downloadFile(HashMap<String, Object> map) {
		try {
			ServletContext servletContext = (ServletContext)map.get("servletContext");
			HttpServletRequest request = (HttpServletRequest)map.get("request");
			HttpServletResponse response = (HttpServletResponse)map.get("response");
			int fileNum = Integer.valueOf(map.get("fileNum").toString());
			String filename 	= (String)map.get("filename");
			String origfilename = (String)map.get("origfilename");
			
			boardUtil.downloadFile(servletContext, request, response, filename, origfilename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Desc : �Խù� ���� ���� �Լ� 
	 * @Method Name : writeBoardContent
	 * @param map
	 */
	public void writeBoardContent(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			BoardDao bd = new BoardDao();
			bd.writeBoardContent(map);
			uploadFiles(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Desc : ���� ���ε� �Լ�
	 * @Method Name : uploadFiles
	 * @param map
	 */
	public void uploadFiles(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			ArrayList fileList = renameUploadFile(map); 
			map.put("fileList", fileList);
			
			BoardDao bd = new BoardDao();
			bd.uploadFiles(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Desc : ���� ���ε�� ���� �̸� �ο� �Լ�
	 * @Method Name : renameUploadFile
	 * @param map
	 * @return
	 */
	public ArrayList renameUploadFile(HashMap<String, Object> map) {
		MultipartRequest multi = (MultipartRequest)map.get("multi");
		String uploadPath = (String)map.get("uploadPath");
		
		ArrayList fileList = new ArrayList();
		
		Enumeration files=multi.getFileNames();
		
		String file = "";
		String filename = "";
		String origfilename = "";
		String renamefilename = "";
		while(files.hasMoreElements()) {
			file =(String)files.nextElement();
			filename = multi.getFilesystemName(file);
			origfilename= multi.getOriginalFileName(file);
			
			System.out.println("filename : " + filename);
			System.out.println("origfilename : " + origfilename);
			
			renamefilename = boardUtil.renameUploadFile(uploadPath, filename);
			
			HashMap<String, String> fileMap = new HashMap<String, String>();
			fileMap.put("filename", renamefilename); // ����� ���� �̸����� ����
			fileMap.put("origfilename", origfilename);
			fileList.add(fileMap);
		}
		
		return fileList;
	}

	/**
	 * Desc : �Խù� ���� ���� �Լ� 
	 * @Method Name : updateBoardContent
	 * @param map
	 */
	public void updateBoardContent(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			BoardDao bd = new BoardDao();
		
			bd.updateBoardContent(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Desc : �Խù� ���� �Լ�
	 * @Method Name : deleteBoardContent
	 * @param map
	 */
	public void deleteBoardContent(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			BoardDao bd = new BoardDao();
			bd.deleteBoardContent(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
