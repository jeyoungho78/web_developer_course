package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServletConfig
 */
public class HelloServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServletConfig() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html; charset=euc_kr"); 
		
		//String name = getInitParameter("name");
		//String job = getInitParameter("job");
		String servletName = getServletName();
		
		ServletConfig config = getServletConfig();
		String name = config.getInitParameter("name");
		String job = config.getInitParameter("job");
		
		PrintWriter out = response.getWriter();
		
		out.write("<hmtl>");
		out.write("	<body>");
		out.write("		<p>name :" + name + "</p>");
		out.write("		<p>job :" + job + "</p>");
		out.write("		<p>servlet name :" + servletName+ "</p>");
		out.write("	</body>");
		out.write("</hmtl>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
