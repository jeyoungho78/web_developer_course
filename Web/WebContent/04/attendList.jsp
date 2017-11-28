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
			<td>�й�</td>
			<td>�����⵵</td>
			<td>�����б�</td>
			<td>�̼�����</td>
			<td>�����ڵ�</td>
			<td>������ȣ</td>
			<td>�̼�����</td>
			<td>�������</td>
			<td>������û����</td>
			<td>����� ����</td>
			<td>����ó������</td>
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

				String sql = "SELECT STU_NO   \n" +
				             "     , ATT_YEAR   \n" +
				             "     , ATT_TERM  \n" +
				             "     , ATT_ISU \n" +
		            		 "     , SUB_CODE   \n" +
				             "     , PROF_CODE  \n" +
				             "     , ATT_PONUMBER \n" +
		            		 "     , ATT_GRADE   \n" +
				             "     , ATT_DIV  \n" +
				             "     , ATT_JAE \n" +
				             "     , ATT_DATE \n" +
				             "  FROM ATTEND"; // �����ų ���� ����
				
				System.out.println(sql);
				               
				rs = stmt.executeQuery(sql); // ���� �����Ͽ� ������ ����

				String stuNo; 			
				String attYear; 		
				int    attTerm;
				int    attIsu;
				String subCode;
				String profCode;
				int    attPonumber;
				int    attGrade;
				String attDiv;
				String attJae;
				Timestamp attDate; 	
  
				while (rs.next()) {
					stuNo         = rs.getString("STU_NO");
					attYear 	  = rs.getString("ATT_YEAR");
					attTerm       = rs.getInt("ATT_TERM");
					attIsu        = rs.getInt("ATT_ISU");
					subCode 	  = rs.getString("SUB_CODE");
					profCode      = rs.getString("PROF_CODE");
					attPonumber   = rs.getInt("ATT_PONUMBER");
					attGrade 	  = rs.getInt("ATT_GRADE");
					attDiv        = rs.getString("ATT_DIV");
					attJae 	      = rs.getString("ATT_JAE");
					attDate 	  = rs.getTimestamp("ATT_DATE");
		%>
		<tr>
			<td><%=stuNo         %></td>
			<td><%=attYear 		 %></td>
			<td><%=attTerm       %></td>
			<td><%=attIsu        %></td>
			<td><%=subCode 	     %></td>
			<td><%=profCode    	 %></td>
			<td><%=attPonumber   %></td>
			<td><%=attGrade 	 %></td>
			<td><%=attDiv        %></td>
			<td><%=attJae 	     %></td>
			<td><%=attDate 	     %></td>
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