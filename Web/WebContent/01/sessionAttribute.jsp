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
		session.setAttribute("id", request.getParameter("usrId"));
	    session.removeAttribute("id");
	    
	    if(session.getAttribute("id") != null) {
	    	// ������������ �̵�
	    } else {
	    	// �α��� �������� �̵�
	    }
	%>
</body>
</html>