<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	�ȳ��ϼ���!
	Hello~!!
	<%
		String name = "ȫ�浿";
	    out.print(name);
		System.out.println("�α׿� �ʱ����������� ����ϴ�.");
	%>
	
	<%
		String id = "hong";
		out.print(id);
	%>
	<p>
	out ��ü�� ������� �ʰ� ������¹�� :
	<%//=id %>
	<%//=id %> <!-- �ּ�ó��  -->
	
</body>
</html>