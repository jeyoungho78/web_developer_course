<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/fileUploadTest.do" enctype="multipart/form-data" method="post">
		<p><input type="file" name="file1">
		<p><input type="file" name="file2">
		<p><input type="submit" name="보내기">
	</form>
</body>
</html>