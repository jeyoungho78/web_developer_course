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
			<td>������ȣ</td>
			<td>������</td>
			<td>���������̸�</td>
			<td>�����ӿ볯¥</td>
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

				String sql = "SELECT PROF_CODE   \n" +
				             "     , PROF_NAME   \n" +
				             "     , PROF_ENAME  \n" +
				             "     , CREATE_DATE \n" +
				             "  FROM PROFESSOR"; // �����ų ���� ����
				
				System.out.println(sql);
				               
				rs = stmt.executeQuery(sql); // ���� �����Ͽ� ������ ����

				String profCode; 			
				String profName; 		
				String profEname; 		
				Timestamp createDate; 	

				while (rs.next()) {
					profCode       = rs.getString("PROF_CODE");
					profName 	   = rs.getString("PROF_NAME");
					profEname      = rs.getString("PROF_ENAME");
					createDate 	   = rs.getTimestamp("CREATE_DATE");
		%>
		<tr>
			<td><%=profCode      %></td>
			<td><%=profName 	 %></td>
			<td><%=profEname     %></td>
			<td><%=createDate    %></td>
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