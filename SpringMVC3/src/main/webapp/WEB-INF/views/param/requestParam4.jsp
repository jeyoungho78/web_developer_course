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
	<form:form commandName="mem">
	<%-- id : <input type="text" name="id" value="${mem.id }"> --%>
	     <p> id : <form:input path="id"/>
	     <p> name : <form:input path="name"/>
	     <p> email : <form:input path="email"/>
	     <p> hobby : 
	     <form:checkbox path="hobby" value="baseball" label="야구"/>
	     <form:checkbox path="hobby" value="reading" label="독서"/>
	     <form:checkbox path="hobby" value="fishing" label="낚시"/>
	     <p> gender :
	     <form:radiobutton path="gender" value="male" label="남자"/>
	     <form:radiobutton path="gender" value="female" label="여자"/>
	     <p> animal : 
	     <form:select path="selAnimal">
	     	<form:options items="${animalMap}"></form:options>
	     </form:select>
	     
	</form:form>
</body>
</html>