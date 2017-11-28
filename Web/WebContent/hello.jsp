<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	안녕하세요!
	Hello~!!
	<%
		String name = "홍길동";
	    out.print(name);
		System.out.println("로그에 초기접근페이지 남깁니다.");
	%>
	
	<%
		String id = "hong";
		out.print(id);
	%>
	<p>
	out 객체를 사용하지 않고 직접출력방법 :
	<%//=id %>
	<%//=id %> <!-- 주석처리  -->
	
</body>
</html>