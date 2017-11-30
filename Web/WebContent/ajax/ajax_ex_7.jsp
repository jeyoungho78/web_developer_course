<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	System.out.println("aJax jsp log");
	System.out.println("첫번째값:" + request.getParameter("num"));
	System.out.println("두번째값:" + request.getParameter("name"));
%>
{"name":"<%=request.getParameter("name")%>"}