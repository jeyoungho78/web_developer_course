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
		<p> ���            : <input type="checkbox" name="hobbyList" value="soccer">�౸ 
					 <input type="checkbox" name="hobbyList" value="reading">���� 
					 <input type="checkbox" name="hobbyList" value="baseball">�߱� 
					 <input type="checkbox" name="hobbyList" value="volleyball">�豸
		<p> ���� 	   : 
					 <select name="animal">
						<option value="dog">��
						<option value="cat">�����
						<option value="cow">��
					 </select>
		<p> ����            : <input type="radio" name="gender" value="0" checked>��   
					 <input type="radio" name="gender" value="1">�� 
		<p>			<input type="submit" value="����">
					<button type="submit" formaction="memberView.do">���峻�뺸��</button>
					<!-- <input type="button" value="���峻�뺸��" > -->
		
	</form>
</body>
</html>