<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/web/contentView.do">
		<p>
		제목 : <input type="text" name="title">
		<p>
		내용 : <input type="text" name="content">
		<p>
		관심분야 : <input type="checkbox" name="interest" value="exerise">운동 &nbsp;
			   <input type="checkbox" name="interest" value="study">공부 &nbsp;
		<p>
		<input type="submit" value="보내기">
	</form>
</body>
</html>