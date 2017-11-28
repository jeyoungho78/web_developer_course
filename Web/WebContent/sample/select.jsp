<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="com.entity.sample.SampleEntity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>학과코드</td>
			<td>학과명</td>
		</tr>
<%
	ArrayList list = (ArrayList)request.getAttribute("list");

	for(int i = 0; i < list.size(); i++) {
%>
	<tr>
  		<td><%=((SampleEntity)list.get(i)).getDeptCode() %></td>
		<td><%=((SampleEntity)list.get(i)).getDeptName() %></td>
 		<%-- <td><%=((HashMap<String, Object>)list.get(i)).get("DEPTCODE") %></td>
		<td><%=((HashMap<String, Object>)list.get(i)).get("DEPTNAME") %></td>
 --%>		<td></td>
	</tr>

<% } %>
</table>
</body>
</html>