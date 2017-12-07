<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.google.gson.*"%>
<%@ page import="com.google.gson.internal.LinkedTreeMap"%>
<%@ page import="java.util.*"%>
<%
	HashMap boardListMap = (HashMap)request.getAttribute("boardListMap");
	Gson gson = new Gson();
%>
{"boardListMap" : <%=gson.toJson(boardListMap) %>}