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
		out.write(" 	서버이름 : " + request.getServerName());
		out.write("<p>");
		out.write(" 	서버프로토콜 : " + request.getProtocol());
		out.write("<p>");
		out.write(" 	서버포트 : " + request.getServerPort());
		out.write("<p>");
		out.write(" 	전달방식 : " + request.getMethod());
		out.write("<p>");
		out.write("		서버루투 : " + request.getSession().getServletContext().getRealPath("/"));
		out.write("<p>");
		out.write("		QueryString : " + request.getQueryString()); // get방식에서만 사용
		out.write("<p>");
		out.write("		클라이언트ip : " + request.getRemoteAddr());
		out.write("<p>");
		out.write("		접속이전페이지 : " + request.getHeader("Referer"));
		out.write("<p>");
		out.write("		접속브라우저정보 : " + request.getHeader("User-Agent"));
		out.write("	</body>");
		out.write("</html>");
	}

}
