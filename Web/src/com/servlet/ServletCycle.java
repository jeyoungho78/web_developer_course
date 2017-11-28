package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCycle
 */
public class ServletCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCycle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init 시작");
		super.init(config);
	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("종료");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
		PrintWriter out = response.getWriter();
		
		//out.write("service 실행");
		//init(getServletConfig());
		String servletName = getServletName();
		
		String servletContext = getServletContext().getServletContextName();
		String realPath = getServletContext().getRealPath(servletName);
		
		out.write("<html>");
		out.write(" <body>");
		out.write("	  servletContext 이름 : " + servletContext);
		out.write("	  <p>서블릿명 : " + servletName);
		out.write("	  <p>" + servletName + "서블릿경로 : " + realPath);
		out.write(" </body>");
		out.write("</html>");
	}

}
