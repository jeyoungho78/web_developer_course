<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	System.out.println("aJax jsp log");
	System.out.println("첫번째값:" + request.getParameterValues("sendData[]")[0]);
	System.out.println("두번째값:" + request.getParameterValues("sendData[]")[1]);
	System.out.println("세번째값:" + request.getParameterValues("sendData[]")[2]);

%>
{"name":"<%=request.getParameterValues("sendData[]")[0]%>"}