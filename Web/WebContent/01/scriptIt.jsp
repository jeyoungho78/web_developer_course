<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% // 스크립트잇
		String innerStr = "";
		
		String retVal = retValue();
		out.print(retVal);
	%>
	<%! // 선언문
		String globalStr = "global";
	%>
	<%! // 선언문
		String retValue(){
			return "retValue";
		}
	%>
	<%=globalStr %> <!-- 표현식 -->
</body>
</html>