<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<p>
	
	<%
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("today", "2017년11월20일입니다.");
		
		pageContext.setAttribute("mapVar", map);
	
	%>
	<c:set var="todayCheck" value="${mapVar}"/>
	<c:out value="${todayCheck.today}"/>
	
	<c:set var="myColor" value="빨강"/> <!-- String myColor = "빨강"; -->
	<c:if test="${myColor == '빨강' }">
		색상은 빨강색이다...
		<c:out value="색상은 빨강색이다."/>
	</c:if>
	<!--
		if(myColor.equals("빨강"){
			System.out.println("색상은 빨강색이다.");
		}
	  -->
	
	<c:set var="grade" value="70"/>
	<c:choose>
		<c:when test="${ grade >= 90 }">
			학점은 A 이다. 
		</c:when>
		<c:when test="${ grade >= 80 }">
			학점은 B 이다. 
		</c:when>
		<c:when test="${ grade >= 70 }">
			학점은 C 이다. 
		</c:when>
		<c:otherwise>
			학점은 F 이다.
		</c:otherwise>
	</c:choose>

</body>
</html>