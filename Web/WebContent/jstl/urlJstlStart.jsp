<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<c:url value="/jstl/urlJstlEnd.jsp" var="moveUrl">	
	<c:param name="name" value="홍길동"></c:param>
	<c:param name="age" value="74"></c:param>
</c:url>

<c:out value="${moveUrl }"/>

<c:redirect url="${moveUrl}">
<%-- 	<c:param name="name" value="홍길동"></c:param>
	<c:param name="age" value="74"></c:param> --%>
</c:redirect>


</body>
</html>