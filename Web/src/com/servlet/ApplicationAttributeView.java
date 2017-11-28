package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ApplicationAttributeView
 */
public class ApplicationAttributeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationAttributeView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = getServletConfig().getServletContext();

		String name = (String) application.getAttribute("name");
		String content = (String) application.getAttribute("content");
		String city = (String) application.getAttribute("city");
		String sradio = (String) application.getAttribute("sradio");
		String[] pet = (String[]) application.getAttribute("pet"); // null

		PrintWriter out = response.getWriter();

		out.write("<html>");
		out.write("	<body>");
		out.write("name : " + name);
		out.write("<p> content : " + content);
		out.write("<p> city : " + city);
		out.write("<p> sradio : " + sradio);
		if (pet != null) {
			for (int i = 0; i < pet.length; i++) {
				out.write("<p> pet[" + i + "] : " + pet[i]);
			}
		}
		out.write(" </body>");
		out.write("</html>");
	}

}
