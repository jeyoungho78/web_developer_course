package com.action.board;

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.board.BoardService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class boardAction
 */
public class BoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		
		// 중요 : 이걸로 경로 설정 변경됨
		String rootURL = "/board/03/";
		
		String cmd = request.getParameter("cmd");
		
		MultipartRequest multi = null;
		String uploadPath = "";
		int size = 0;
		
		if(cmd == null && (request.getMethod()).equals("GET")) {
			cmd ="list";
		} else if (cmd == null && (request.getMethod()).equals("POST")) {
			uploadPath = request.getRealPath("/upload");
			size = 10*1024*1024;
			multi = new MultipartRequest(request,
					uploadPath,
					size, 
					"EUC-KR",
					new DefaultFileRenamePolicy());
			
			cmd = multi.getParameter("cmd");
		}
				
		System.out.println("cmd : " + cmd);
		
		if(cmd.equals("list")) {
			// #1 : request 파라미터 
			int totalContentCount 		= Integer.valueOf(request.getParameter("totalContentCount") == null? "0" : request.getParameter("totalContentCount"));    // 전체 컨텐츠 개수
			int perPageContentCount 	= Integer.valueOf(request.getParameter("perPageContentCount") == null? "0" : request.getParameter("perPageContentCount"));  // 페이지당 컨텐츠 개수
			int perPageViewPageCount 	= Integer.valueOf(request.getParameter("perPageViewPageCount") == null? "0" : request.getParameter("perPageViewPageCount")); // 페이지당 보여질 페이지 개수
			int selectedPage            = Integer.valueOf(request.getParameter("selectedPage") == null? "0" : request.getParameter("selectedPage"));
			String field 			    = request.getParameter("field") == null? "" : request.getParameter("field");
			String searchWord 	     	= request.getParameter("searchWord") == null? "" : request.getParameter("searchWord");
				
			// 테스트 설정값
			totalContentCount = 100;
			perPageContentCount = 5;
			perPageViewPageCount = 2;
			if (selectedPage == 0) {
			   selectedPage = 1;
			}
			
			// #2 : service 넘길 인자값
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("totalContentCount", 	totalContentCount);
			map.put("perPageContentCount", 	perPageContentCount);
			map.put("perPageViewPageCount", perPageViewPageCount);
			map.put("selectedPage", 		selectedPage);
			map.put("field", 				field);
			map.put("searchWord", 			searchWord);
			
			// #3 : service 실행 
			BoardService bs = new BoardService();
			HashMap<String, Object> boardListMap = bs.getBoardList(map);
			
			// #4 : service 리턴값 
			request.setAttribute("boardListMap", boardListMap);
			
			// #5 : 페이지 이동
			String url = rootURL + "boardList.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		
		} else if (cmd.equals("view")) {
			int selectedPage    = Integer.valueOf(request.getParameter("selectedPage") == null? "0" : request.getParameter("selectedPage"));
			int boardNum        = Integer.valueOf(request.getParameter("boardNum") == null? "0" : request.getParameter("boardNum"));
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("selectedPage", selectedPage);
			map.put("boardNum", 	boardNum);
			
			BoardService bs = new BoardService();
			HashMap<String, Object> boardViewMap = bs.viewBoardContent(map);
			
			request.setAttribute("boardViewMap", boardViewMap);
			
			String url = rootURL + "boardView.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} else if (cmd.equals("download")) {
			int fileNum    		= Integer.valueOf(request.getParameter("fileNum") == null? "0" : request.getParameter("fileNum"));
			String filename 	= request.getParameter("filename") == null? "" : request.getParameter("filename");
			String origfilename = request.getParameter("origfilename") == null? "" : request.getParameter("origfilename");
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("servletContext", getServletContext());
			map.put("request", request);
			map.put("response", response);
			map.put("fileNum", fileNum);
			map.put("filename", filename);
			map.put("origfilename", origfilename);
			
			BoardService bs = new BoardService();
			bs.downloadFile(map);
				
		} else if (cmd.equals("write")) {		
			String boardTitle   = multi.getParameter("boardTitle") == null? "" : multi.getParameter("boardTitle");
			String boardWriter 	= multi.getParameter("boardWriter") == null? "" : multi.getParameter("boardWriter");
			String boardContent = multi.getParameter("boardContent") == null? "" : multi.getParameter("boardContent");
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("boardTitle",   boardTitle);
			map.put("boardWriter",  boardWriter);
			map.put("boardContent", boardContent);
			map.put("multi", multi);
			map.put("uploadPath", uploadPath);
			
			BoardService bs = new BoardService();
			bs.writeBoardContent(map);
			
			String url ="/BoardAction?cmd=list";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);	
			
		} else if (cmd.equals("updateView")) {
			int selectedPage    = Integer.valueOf(request.getParameter("selectedPage") == null? "0" : request.getParameter("selectedPage"));
			int boardNum        = Integer.valueOf(request.getParameter("boardNum") == null? "0" : request.getParameter("boardNum"));
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("selectedPage", selectedPage);
			map.put("boardNum",     boardNum);
			
			BoardService bs = new BoardService();
			HashMap<String, Object> boardViewMap = bs.viewBoardContent(map);
			
			request.setAttribute("selectedPage", selectedPage);
			request.setAttribute("boardNum", boardNum);
			request.setAttribute("boardViewMap", boardViewMap);
			
			String url = rootURL + "/boardUpdate.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
			
		} else if (cmd.equals("update")) {
			int selectedPage    = Integer.valueOf(request.getParameter("selectedPage") == null? "0" : request.getParameter("selectedPage"));
			int boardNum        = Integer.valueOf(request.getParameter("boardNum") == null? "0" : request.getParameter("boardNum"));
			String boardTitle   = request.getParameter("boardTitle") == null? "" : request.getParameter("boardTitle");
			String boardWriter 	= request.getParameter("boardWriter") == null? "" : request.getParameter("boardWriter");
			String boardContent = request.getParameter("boardContent") == null? "" : request.getParameter("boardContent");
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("selectedPage", selectedPage);
			map.put("boardNum",     boardNum);
			map.put("boardTitle",   boardTitle);
			map.put("boardWriter",  boardWriter);
			map.put("boardContent", boardContent);
			
			BoardService bs = new BoardService();
			bs.updateBoardContent(map);
			
			request.setAttribute("selectedPage", selectedPage);
			request.setAttribute("boardNum", boardNum);
			
			String url ="/BoardAction?cmd=view";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
			
		} else if (cmd.equals("delete")) {
			int selectedPage    = Integer.valueOf(request.getParameter("selectedPage") == null? "0" : request.getParameter("selectedPage"));
			int boardNum        = Integer.valueOf(request.getParameter("boardNum") == null? "0" : request.getParameter("boardNum"));
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("selectedPage", selectedPage);
			map.put("boardNum",     boardNum);
			
			BoardService bs = new BoardService();
			bs.deleteBoardContent(map);
			
			String url ="/BoardAction?cmd=list";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);			
		}
	
	}

}
