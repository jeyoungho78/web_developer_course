<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="member">
		<p> id     : <form:input path="id"/>
		<p> name   : <form:input path="name"/>
		<p> email  : <form:input path="email"/>
		<p> 취미            : <form:checkbox path="hobby" value="soccer"     lable="축구"/> 
					 <form:checkbox path="hobby" value="reading"    lable="독서 "/>
					 <form:checkbox path="hobby" value="baseball"   lable="야구"/> 
					 <form:checkbox path="hobby" value="volleyball" lable="배구"/>
		<p> 동물 	   : 
					 <form:select path="animal">
					 	<form:options items="${animalMap}"></form:options>
					 </form:select>
		<p> 성별            : <form:radiobutton path="gender" value="male" label="남"/>   
					 <form:radiobutton path="gender" value="female" label="여"/> 
		<p>			<input type="submit" value="저장">
					<button type="submit" formaction="memberView.do">저장내용보기</button>
					<!-- <input type="button" value="저장내용보기" > -->
		
	</form:form>
</body>
</html>