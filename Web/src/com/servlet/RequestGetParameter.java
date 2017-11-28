package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestGetParameter
 */
public class RequestGetParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestGetParameter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String city = request.getParameter("city");
		String sradio = request.getParameter("sradio");
		String[] pet = request.getParameterValues("pet");
		String[] sradioArr = request.getParameterValues("sradio");

		out.write("<html>");
		out.write(" <body>");
		out.write(" 	<p> name : " + name + "</p>");
		out.write(" 	<p> content : " + content + "</p>");
		out.write(" 	<p> city : " + city + "</p>");
//		out.write(" 	<p> sradio : " + sradio + "</p>");
//		for (int i = 0; i < pet.length; i++) {
//			out.write(" 	<p> pet[" + i + "]: " + pet[i] + "</p>");
//		}
//		out.write(" 	<p> sradioArr : " + sradioArr[0] + "</p>");
		out.write(" </body>");
		out.write("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
