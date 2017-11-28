package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class requestInfo
 */
public class requestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requestInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("euc_kr");
		
		PrintWriter out = response.getWriter();
		
		out.write("<html>");
		out.write("	<body>");
		out.write(" 	�����̸� : " + request.getServerName());
		out.write("<p>");
		out.write(" 	������������ : " + request.getProtocol());
		out.write("<p>");
		out.write(" 	������Ʈ : " + request.getServerPort());
		out.write("<p>");
		out.write(" 	���޹�� : " + request.getMethod());
		out.write("<p>");
		out.write("		�������� : " + request.getSession().getServletContext().getRealPath("/"));
		out.write("<p>");
		out.write("		QueryString : " + request.getQueryString()); // get��Ŀ����� ���
		out.write("<p>");
		out.write("		Ŭ���̾�Ʈip : " + request.getRemoteAddr());
		out.write("<p>");
		out.write("		�������������� : " + request.getHeader("Referer"));
		out.write("<p>");
		out.write("		���Ӻ��������� : " + request.getHeader("User-Agent"));
		out.write("	</body>");
		out.write("</html>");
	}

}
