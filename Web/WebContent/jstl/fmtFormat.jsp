<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL fmt 라이브러리 실습</h1>
	
	<c:set var="myDate" value="<%=new java.util.Date() %>"/>
	<c:out value="${myDate }"/>
	<br>
	
	<fmt:formatDate value="${myDate }" pattern="yyyy-MM-dd"/>
	<br>
	
	<c:set var="myString" value="20020101111111"/>
	<c:out value="${myString }"/>
	<fmt:parseDate var="insert_date" value="${myString}" pattern="yyyyMMddHHmmss"/>
	<c:out value="${insert_date }"/>
	<br>
	
	<fmt:formatDate value="${myDate }" type="date"/>
	<br>
	<fmt:formatDate value="${myDate }" type="time"/>
	<br>
	<fmt:formatDate value="${myDate }" type="both"/>
	<br>
	<fmt:formatDate value="${myDate }" type="both" dateStyle="short" timeStyle="long"/>
	<br>
	<fmt:formatDate value="${myDate }" type="both" dateStyle="long" timeStyle="short"/>
	<br>
	
	<h1>JSTL fmt 라이브러리 실습</h1>
	
	<fmt:formatNumber value="100000" type="currency" currencySymbol="$"/> 
	<br>
	<fmt:formatNumber value="0.123" type="percent"/> 
	<br>
	<fmt:formatNumber value="987654321.1234" pattern="###,###,###.00"/>
	<br>
	
</body>
</html>