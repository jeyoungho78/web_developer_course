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
		<p> ���            : <form:checkbox path="hobby" value="soccer"     lable="�౸"/> 
					 <form:checkbox path="hobby" value="reading"    lable="���� "/>
					 <form:checkbox path="hobby" value="baseball"   lable="�߱�"/> 
					 <form:checkbox path="hobby" value="volleyball" lable="�豸"/>
		<p> ���� 	   : 
					 <form:select path="animal">
					 	<form:options items="${animalMap}"></form:options>
					 </form:select>
		<p> ����            : <form:radiobutton path="gender" value="male" label="��"/>   
					 <form:radiobutton path="gender" value="female" label="��"/> 
		<p>			<input type="submit" value="����">
					<button type="submit" formaction="memberView.do">���峻�뺸��</button>
					<!-- <input type="button" value="���峻�뺸��" > -->
		
	</form:form>
</body>
</html>