<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/SampleAction">
		학과코드 : <input type="text" name="deptCode">
		<input type="hidden" name="cmd" value="select">
		<p>
		<input type="submit" value="조회하기">
	</form>
	---------------------------------------------
	<form action="/SampleAction">
		학과코드 : <input type="text" name="deptCode" value="90">
			   <p>
		학과명 : <input type="text" name="deptName" value="국문과">
			  <p>
		학과영문명 : <input type="text" name="deptEname" value="Dept. of Korea language">
				<p>
		<input type="hidden" name="cmd" value="insert">
		<p>
		<input type="submit" value="입력하기">
	</form>
</body>
</html>