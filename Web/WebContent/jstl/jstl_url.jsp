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
<c:url value="http://search.daum.net/search" var="searchUrl">
    <c:param name="w" value="blog" />
    <c:param name="q" value="공원" />
</c:url>

<ul>
    <li>${searchUrl}</li>
    <li><c:url value="/use_if_tag.jsp" /></li>
    <li><c:url value="./use_if_tag.jsp" /></li>
</ul>

</body>
</html>
