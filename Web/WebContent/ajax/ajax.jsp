<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	System.out.println("aJax jsp log");
	System.out.println("ù��°��:" + request.getParameterValues("sendData[]")[0]);
	System.out.println("�ι�°��:" + request.getParameterValues("sendData[]")[1]);
	System.out.println("����°��:" + request.getParameterValues("sendData[]")[2]);

%>
{"name":"<%=request.getParameterValues("sendData[]")[0]%>"}