<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
td {
	text-align: center; width:45px; height:20px;
}
</style>
</head>

<body>
    <h1>Table</h1>
	<table border="1" width="300" height="300">
		<%  Random rd = new Random();
			int num = -1;
			
			// request 값이 있는지 체크해서 있으면 난수로 설정
			String randomNum = (String)request.getAttribute("randomNum");
			if(randomNum != null){
				num = Integer.valueOf(randomNum);
			} else {
				num = rd.nextInt(30) + 1;
			}
		%>
		<tr>
			<td>숫자</td>
			<td colspan="3">
			<%=num%><br>
			(<% Date date = new Date();
				SimpleDateFormat  sdf = new SimpleDateFormat("yyyy.MM.dd hh시mm분ss초" );
				out.print(sdf.format(date));
			  %>)</td>
		</tr>
		<% int value = 1;
		   for (int row = 0; row < 4; row++) { 
		%>
		<tr>
			<% for (int col = 0; col < 4; col++) { %>
			<td>
				<% if (value <= num) {
								out.print(value);
							}
				   value++; 
				%>
			</td>
			<% } %>
		</tr>
		<% } %>
	</table>
	<p>
	<% int spaceCellCnt = 0;
	   if(num < 16){
			spaceCellCnt = 16 - num;
		} 
	%>
	<form id="myForm" action="./table_receive.jsp" method="get">
		난수 : <input type="text" name="randomNum" value=<%=num %>>
		<p>
		빈칸 : <input type="text" name="spaceCellCnt" value=<%=spaceCellCnt %>>
		<p>
		<% if(randomNum != null) {%>
			<!-- <a href="./table.jsp">재생성</a> -->
			<!-- <a href="./table.jsp" onclick="document.getElementById('myForm').submit();">재생성</a> -->
			<input type="button" onclick="location.href='table.jsp'" value="재생성 ">
		<% } else { %>
			<input type="submit" value="보내기">
		<% } %>
	</form>
</body>
</html>