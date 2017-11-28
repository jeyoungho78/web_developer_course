package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestViewServlet
 */
public class TestViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		Cookie[] cook = request.getCookies();
		
		if(cook != null && cook.length > 0) {
			for(int i = 0; i < cook.length; i++) {
				if(cook[i].getName().equals("id")) {
					out.write("<p>id: " + cook[i].getValue());
				}
				if(cook[i].getName().equals("passwd")) {
					out.write("<p>passwd: " + cook[i].getValue());
				}
			}
		}
	}

}
