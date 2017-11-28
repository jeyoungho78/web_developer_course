package com.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.*;

/**
 * Servlet implementation class RequestGetPagingInfo
 */
public class RequestGetPagingInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetPagingInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		String totalContentCount = request.getParameter("totalContentCount");
		String perPageContentCount = request.getParameter("perPageContentCount");
		String perPageViewPageCount = request.getParameter("perPageViewPageCount");
		String selectedPage = request.getParameter("selectedPage");
		
		if(totalContentCount.equals("") || perPageContentCount.equals("") 
				|| totalContentCount.equals("") || perPageViewPageCount.equals("")) {
			out.write("element is empty! please input data!");
			return;
		}

		PagingInfo pi = new PagingInfo(out);
		
		response.setContentType("text/html; charset=euc_kr");
		out.write("<html>");
		out.write("	<body>");
		out.write("  <p> totalContentCount : " + totalContentCount + "</p>");
		out.write("  <p> perPageContentCount : " + perPageContentCount + "</p>");
		out.write("  <p> perPageViewPageCount : " + perPageViewPageCount + "</p>");
		out.write("  <p> selectedPage : " + selectedPage + "</p>");
		out.write("  <p>");
		out.write("   " + pi.getUnderPage(totalContentCount, perPageContentCount, perPageViewPageCount, selectedPage));
		out.write("  </p>");
		out.write("	</body>");
		out.write("<html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
