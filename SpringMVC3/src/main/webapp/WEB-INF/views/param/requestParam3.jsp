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
	<p> ID : ${mem.id}
	<p> NAME : ${mem.name}
	<p> EMAIL : ${mem.email}
	<p>
	
	<c:forEach var="animal" items="${animal}">
		${animal} &nbsp;
	</c:forEach>
	<p> Hobby : &nbsp;
	<c:forEach var="hobby" items="${mem.hobby}">
		${hobby} &nbsp; 
	</c:forEach>
</body>
</html>