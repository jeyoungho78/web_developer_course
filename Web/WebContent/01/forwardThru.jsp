<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% 
		String chkValue = request.getParameter("chkValue");
	
		if(chkValue != null && !chkValue.equals("")){
			// 规过 #1
			//RequestDispatcher dis = request.getRequestDispatcher(chkValue);
			//dis.forward(request, response);
			
			// 规过 #2
			//response.sendRedirect(chkValue);
		}
	%>
	
	<!-- 规过 #3 -->
	<jsp:forward page="<%=chkValue %>"/>
</body>
</html>