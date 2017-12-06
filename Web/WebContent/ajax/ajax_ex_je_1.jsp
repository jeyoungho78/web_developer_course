<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.google.gson.*"%>
<%@ page import="com.google.gson.internal.LinkedTreeMap"%>
<%@ page import="java.util.*"%>
<%
    Object key = request.getParameter("key");
	System.out.println(key);
	
	//ArrayList list = new Gson().fromJson(key, ArrayList.class);
	//System.out.println("map : " + list);
	
	/* Enumeration em = request.getParameterNames();
    while(em.hasMoreElements()){
    	String parameterName = (String)em.nextElement();
    	System.out.println(parameterName);
    } */

    //String key = request.getParameter("key");

	//HashMap map = new Gson().fromJson(key, HashMap.class);
	//System.out.println("map : " + map);
	
	//System.out.println(list.get(0));
	
	/* for(int i = 0; i < list.size(); i++){
		System.out.println(list.get(i));
	}  */ 
	
%>
{"name":"<%=request.getParameter("name")%>}