package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionAttribute
 */
public class SessionAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionAttribute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String city = request.getParameter("city");
		String sradio = request.getParameter("sradio");
		String[] pet = request.getParameterValues("pet"); //null
		
		HttpSession session = request.getSession(false);
		
		session.setAttribute("name", name);
		session.setAttribute("content", content);
		session.setAttribute("city", city);
		session.setAttribute("sradio", sradio);
		session.setAttribute("pet", pet);
		
		// 경로이동 방법 #1
		String url = "/SessionAttributeView";
		RequestDispatcher dis = getServletContext().getRequestDispatcher(url);
		dis.forward(request, response);
		
		// 경로이동 방법 #2
		//response.sendRedirect(url);
	}

}
