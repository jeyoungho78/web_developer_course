package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationAttribute
 */
public class ApplicationAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationAttribute() {
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
		
		ServletContext application = getServletConfig().getServletContext();
		
		application.setAttribute("name", name);
		application.setAttribute("content", content);
		application.setAttribute("city", city);
		application.setAttribute("sradio", sradio);
		application.setAttribute("pet", pet);
		
		String url = "/ApplicationAttributeView";
		response.sendRedirect(url);
		
	}

}
