<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/web/paramExamPrint.do">
		<p> id    : <input type="text" name="id">
		<p> name  : <input type="text" name="name">
		<p> email : <input type="text" name="email">
		<p> hobby : <input type="checkbox" name="hobby" value="baseball">具备,
					<input type="checkbox" name="hobby" value="football">绵备,
					<input type="checkbox" name="hobby" value="basketball">丑备
		<p> <input type="submit" name="submit" value="傈价窍扁">
	</form>
</body>
</html>