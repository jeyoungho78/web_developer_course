package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetParameterNames
 */
public class RequestGetParameterNames extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetParameterNames() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		Enumeration<String> enumr = request.getParameterNames();
		String name = "";
		String value = "";
		
		out.write("<html>");
		out.write("	<body>");
		while(enumr.hasMoreElements()) {
			name = (String)enumr.nextElement();
			//out.write("ParameterName is : " + name + "<p>");
			value = request.getParameter(name);
			out.write("<p>" + name + " : " + value + "</p>");
		}
		out.write("	</body>");
		out.write("</html>");
	}

}
