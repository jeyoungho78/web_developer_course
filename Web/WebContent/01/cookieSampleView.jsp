<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.net.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cook = request.getCookies();
		String name = "";
		String value = "";

		if (cook != null && cook.length > 0) {
			for (int i = 0; i < cook.length; i++) {
				name = cook[i].getName();
				if(name.equals("id")){
					value = cook[i].getValue();
					out.print("name : " + name + " value : " + URLDecoder.decode(value) + "<br>");	
				}	
			}
		}
	%>
</body>
</html>