<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
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
	<%  Random rd = new Random();
		int num = -1;

		// request ���� �ִ��� üũ�ؼ� ������ ������ ����
		String randomNum = (String) request.getAttribute("randomNum");
		if (randomNum != null) {
			num = rd.nextInt(Integer.valueOf(randomNum)) + 1;
		}
	%>
	<h1>Table_Receive2</h1>
	<table border="1" width="300" height="300">
		<tr>
			<td>����</td>
			<td colspan="3">
			<%=num%><br>
			(<% Date date = new Date();
				SimpleDateFormat  sdf = new SimpleDateFormat("yyyy.MM.dd hh��mm��ss��" );
				out.print(sdf.format(date));
			  %>)</td>
		</tr>
		
		<%  int numRows = (num%4 == 0)? (num/4) : (num/4) + 1;
		    int numCols = 4;
		    int value = 1;
			for(int row = 0; row < numRows; row++) {
		%>
	   <tr>
		<% for (int col=0; col < numCols; col++) { %>	
			<td>
				<% if(value <= num) {
					out.print(value);
				}
				value++; 
				%>
			</td>
		<% } %>
		</tr>
	<% } %>
	</table>
</body>
</html>