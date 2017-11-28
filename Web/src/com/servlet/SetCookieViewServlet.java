package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieViewServlet
 */
public class SetCookieViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SetCookieViewServlet() {
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
		Cookie[] cook = request.getCookies();

		String id = "";
		String passwd = "";

		String name = "";

		// 쿠키 삭제하기
//		if (cook != null && cook.length > 0) {
//			for (int i = 0; i < cook.length; i++) {
//				if (cook[i].getName().equals("id")) {
//					Cookie cookie = new Cookie("id", "");
//					cookie.setMaxAge(0);
//					response.addCookie(cookie);
//				}
//			}
//		}

		if (cook != null && cook.length > 0) {
			for (int i = 0; i < cook.length; i++) {
				name = cook[i].getName();

				if (name.equals("id")) {
					id = cook[i].getValue();
				}

				if (name.equals("passwd")) {
					passwd = cook[i].getValue();
				}
			}
		}

		PrintWriter out = response.getWriter();

		out.write("<html>");
		out.write("	<body>");
		out.write("		id : " + id);
		out.write("		<p>");
		out.write("		password : " + passwd);
		out.write("	<body>");
		out.write("	</body>");
		out.write("</html>");

	}

}
