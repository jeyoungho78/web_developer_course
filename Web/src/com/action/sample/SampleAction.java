package com.action.sample;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.sample.SampleEntity;
import com.service.sample.SampleService;

/**
 * Servlet implementation class SampleAction
 */
public class SampleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("insert")) {
			// 등록에 관련된 내용을 처리한다.
			String deptCode = request.getParameter("deptCode");
			String deptName = request.getParameter("deptName");
			String deptEname = request.getParameter("deptEname");
			
			HashMap<String, String>map = new HashMap<String, String>();
			map.put("deptCode", deptCode);
			map.put("deptName", deptName);
			map.put("deptEname", deptEname);
			
			SampleService sSvc = new SampleService();
			sSvc.insertSampleMap(map);
			
			ArrayList list = sSvc.getSampleAllList();
			
			request.setAttribute("list", list);
			String url ="/sample/select.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);

			
		} else if(cmd.equals("select")) {
			/*// 조회 관련된 내용 처리 
			// service 로직 처리
			String deptCode = request.getParameter("deptCode");
			System.out.println("deptCode : " + deptCode);
			
			//SampleEntity se = new SampleEntity();
			//se.setDeptCode(deptCode);
			
			SampleService sSvc = new SampleService();
			//ArrayList list = sSvc.getSampleList(se);
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("deptCode", deptCode);
			ArrayList list = sSvc.getSampleList(map);
			
			request.setAttribute("list", list);
			// 이동할 경로로 데이터를 처리 (view처리)
			String url ="/sample/select.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);*/
			
			SampleService sSvc = new SampleService();
			SampleEntity se = new SampleEntity();
			
			se.setDeptCode("10");
			
			ArrayList list = sSvc.getSampleList(se);
			
			request.setAttribute("list", list);
			// 이동할 경로로 데이터를 처리 (view처리)
			String url ="/sample/select.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
			
			
		} else if(cmd.equals("update")) {
			// 수정에 관련된 내용 처리 
	    } else if(cmd.equals("delete")) {
			// 삭제에 관련된 내용을 처리한다.
		} else if(cmd.equals("sampleInsertFront")) {
			String url = "/sample/sampleInsertFront.html";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} else if(cmd.equals("sampleInsertEnd")) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("deptCode", request.getParameter("deptCode"));
			map.put("deptName", request.getParameter("deptName"));
			map.put("deptEname", request.getParameter("deptEname"));
			
			SampleService sSvc = new SampleService();
			sSvc.sampleInsertEnd(map);
			
			String url = "/SampleAction?cmd=select";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}

}
