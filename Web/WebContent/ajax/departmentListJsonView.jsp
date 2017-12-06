<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.google.gson.*"%>
<%@ page import="com.google.gson.internal.LinkedTreeMap"%>
<%@ page import="java.util.*"%>
<%
    ArrayList list = (ArrayList)request.getAttribute("list");
	Gson gson = new Gson();
%>
{"list" : <%=gson.toJson(list) %>}