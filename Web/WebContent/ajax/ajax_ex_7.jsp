<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	System.out.println("aJax jsp log");
	System.out.println("ù��°��:" + request.getParameter("num"));
	System.out.println("�ι�°��:" + request.getParameter("name"));
%>
{"name":"<%=request.getParameter("name")%>"}