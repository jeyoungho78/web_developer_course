<%@page import="javax.servlet.annotation.MultipartConfig"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>�����ȣ</td>
			<td>�����</td>
			<td>���������</td>
			<td>�����⵵</td>
		</tr>
		
		<%@  include file="./dbConnectionInfo.jsp" %>
		
		<%
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {
				
				Class.forName(driver); // ����̹��ε�
				con = DriverManager.getConnection(url, userid, passwd); // �����ͺ��̽��� ����

				stmt = con.createStatement(); // ������ �����ϱ� ���� ��ü����

				String sql = "SELECT SUB_CODE   \n" +
				             "     , SUB_NAME   \n" +
				             "     , SUB_ENAME  \n" +
				             "     , CREATE_YEAR \n" +
				             "  FROM SUBJECT"; // �����ų ���� ����
				
				System.out.println(sql);
				               
				rs = stmt.executeQuery(sql); // ���� �����Ͽ� ������ ����

				String subCode; 			
				String subName; 		
				String subEname; 		
				String createYear; 	

				while (rs.next()) {
					subCode       = rs.getString("SUB_CODE");
					subName 	  = rs.getString("SUB_NAME");
					subEname      = rs.getString("SUB_ENAME");
					createYear 	  = rs.getString("CREATE_YEAR");
		%>
		<tr>
			<td><%=subCode      %></td>
			<td><%=subName 		%></td>
			<td><%=subEname     %></td>
			<td><%=createYear   %></td>
		</tr>

		<%
				} //while 
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
			}
		%>
	</table>
</body>
</html>