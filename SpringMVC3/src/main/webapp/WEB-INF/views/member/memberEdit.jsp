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
	<form action="memberInsert.do">
		<p> id     : <input type="text" name="id">
		<p> name   : <input type="text" name="name">
		<p> email  : <input type="text" name="email">
		<p> 취미            : <input type="checkbox" name="hobbyList" value="soccer">축구 
					 <input type="checkbox" name="hobbyList" value="reading">독서 
					 <input type="checkbox" name="hobbyList" value="baseball">야구 
					 <input type="checkbox" name="hobbyList" value="volleyball">배구
		<p> 동물 	   : 
					 <select name="animal">
						<option value="dog">개
						<option value="cat">고양이
						<option value="cow">소
					 </select>
		<p> 성별            : <input type="radio" name="gender" value="0" checked>남   
					 <input type="radio" name="gender" value="1">여 
		<p>			<input type="submit" value="저장">
					<button type="submit" formaction="memberView.do">저장내용보기</button>
					<!-- <input type="button" value="저장내용보기" > -->
		
	</form>
</body>
</html>