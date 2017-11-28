<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="./javaBeanExampleEnd.jsp">
		id : <input type="text" name="id">
		<p>
		pw : <input type="text" name="passwd">
		<p>
		<a href="?name=ppp@value=yyy">링크</a> <!-- 쿼리스트링 -->
		<input type="submit" value="보내기">
	</form>
</body>
</html>