<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page buffer="1kb" %>
<%@ page autoFlush="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		Enumeration<String> initParam = application.getInitParameterNames();
		String initParamName = "";
		while(initParam.hasMoreElements()){
			initParamName = (String)initParam.nextElement();
	%>
		 <p>name : <%=initParamName %> value : <%=application.getInitParameter(initParamName) %> 
	<% } %>
	<% for(int i = 0; i < 3000; i++){
		out.print("1234");
	}
	%>
</body>
</html>