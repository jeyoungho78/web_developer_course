<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL Core 라이브러리 실습1</h1>
	<c:forEach var="n" items="${myArray}">
		<c:out value="${n}"/>
	</c:forEach>
	
	<h1>JSTL Core 라이브러리 실습2</h1>
	<c:forEach var="n" items="${myArray}" begin="0" end="6">
		<c:out value="${n}"/>
	</c:forEach>
	
	<h1>JSTL Core 라이브러리 실습3</h1>
	
	<c:forEach var="n" items="${name}">
		<c:out value="${n}"/>
	</c:forEach>
	
	<br>
	<h1>JSTL Core 라이브러리 실습4</h1>
	
	<c:forEach var="job" items="${job}" varStatus="status" begin="0" end="1" step="1">
		{<c:out value="${status.index + 1}" />번째 : <c:out value="${job.jobCode }"/> 
		- <c:out value="${job.jobName }"/>}
	</c:forEach>
	
	<!--  
		varStatus 속성은 루프 정보를 담는다.
		속성값은
		.index - 루프 실행에서 현재 인덱스
		.count - 루프 실행 회수
		.begin - begin 속성값
		.end   - end 속성값
		.step  - step 속성값
		.first - 현재 실행이 첫번째 실행인 경우 true
		.last  - 현재 실행이 마지막 실행인 경우 true
		.current - 콜렉션 중 현재 루프에서 사용할 객체
	-->
	
	
	<h1>JSTL Core 라이브러리 실습5</h1>
	
	<c:forTokens var="n" items="${data }" delims=",">
		<c:out value="${n}"/>
		<br>
	</c:forTokens>
	
	<h1>JSTL Core 라이브러리 실습6</h1>
	
	<c:forEach var="loop" begin="1" end="5" step="1">
		[<c:out value="${loop }"></c:out>]
	</c:forEach>
</body>
</html>