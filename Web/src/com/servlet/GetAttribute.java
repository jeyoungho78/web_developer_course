package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAttribute
 */
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAttribute() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String city = request.getParameter("city");
		String sradio = request.getParameter("sradio");
		String[] pet = request.getParameterValues("pet");

		request.setAttribute("name", name);
		request.setAttribute("content", content);
		request.setAttribute("city", city);
		request.setAttribute("sradio", sradio);
		request.setAttribute("pet", pet);

		// 경로이동 방법 #1
		String url = "/GetAttributeView";
//		RequestDispatcher dis = getServletContext().getRequestDispatcher(url); 
//		dis.forward(request, response);
		
		// 경로이동 방법 #2
		response.sendRedirect(url);
		
		
		/************************************************************************************/
		
		/*PrintWriter out = response.getWriter();

		if (name.equals("") || content.equals("") || city.equals("") || sradio.equals("") || pet.length == 0) {
			out.write("필수 입력 항목이 비어 있습니다. 다시 입력해주세요");
			return;
		}

		/*out.write("<html>");
		out.write("	<body>");
		out.write("name : " + (String) request.getAttribute("name"));
		out.write("<p> content : " + (String) request.getAttribute("content"));
		out.write("<p> city : " + (String) request.getAttribute("city"));
		out.write("<p> sradio : " + (String) request.getAttribute("sradio"));

		if (pet != null) {
			String[] attributePet = (String[]) request.getAttribute("pet");
			for (int i = 0; i < attributePet.length; i++) {
				out.write("<p> pet[" + i + "] : " + attributePet[i]);
			}
		}
		out.write(" </body>");
		out.write("</html>");*/
	}

}
