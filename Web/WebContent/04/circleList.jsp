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
			<td>���Ƹ����Թ�ȣ</td>
			<td>���Ƹ���</td>
			<td>�й�</td>
			<td>�̸�</td>
			<td>��ǥ</td>
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

				String sql = "SELECT CIR_NUM    \n" +
				             "     , CIR_NAME   \n" +
				             "     , STU_NO     \n" +
				             "     , STU_NAME   \n" +
				             "     , PRESIDENT  \n" +
				             "  FROM CIRCLE"; // �����ų ���� ����
				
				System.out.println(sql);
				               
				rs = stmt.executeQuery(sql); // ���� �����Ͽ� ������ ����
                
				int    cirNum;
				String cirName; 			
				String stuNo; 		
				String stuName; 		
				String president; 	

				while (rs.next()) {
					cirNum       = rs.getInt("CIR_NUM");
					cirName      = rs.getString("CIR_NAME");
					stuNo 	     = rs.getString("STU_NO");
					stuName      = rs.getString("STU_NAME");
					president 	 = rs.getString("PRESIDENT");
		%>
		<tr>
			<td><%=cirNum        %></td>
			<td><%=cirName   	 %></td>
			<td><%=stuNo 	     %></td>
			<td><%=stuName       %></td>
			<td><%=president     %></td>
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