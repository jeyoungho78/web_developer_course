package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		Cookie[] cook = request.getCookies();
		
		if(cook != null && cook.length > 0) {
			for(int i = 0; i < cook.length; i++) {
				System.out.println("cook.length : " + cook.length);
				System.out.println("i : " + i);
				
				if(cook[i].getName().equals("id")) {
					Cookie tempCookie = new Cookie("id", "");
					tempCookie.setMaxAge(0);
					response.addCookie(tempCookie);
				}
				
				if(cook[i].getName().equals("passwd")) {
					Cookie tempCookie = new Cookie("passwd", "");
					tempCookie.setMaxAge(0);
					response.addCookie(tempCookie);
				}			
			}
		}
		
		Cookie idCookie = new Cookie("id", id);
		idCookie.setMaxAge(60*60*24*365);
		idCookie.setPath("/02");
		//idCookie.setDomain("www.daum.net");
		
		Cookie pwdCookie = new Cookie("passwd", passwd);
		pwdCookie.setMaxAge(60*60*24*365);
		pwdCookie.setPath("/02");
		//pwdCookie.setDomain("www.daum.net");
		
		response.addCookie(idCookie);
		response.addCookie(pwdCookie);
		
		System.out.println("id : " + id);
		System.out.println("passwd : " + passwd);
		
		response.sendRedirect("/SetCookieViewServlet");
	}

}
