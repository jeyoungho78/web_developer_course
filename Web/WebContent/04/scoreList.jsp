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
			<td>�������⵵</td>
			<td>�б�</td>
			<td>��û����</td>
			<td>�������</td>
			<td>�������</td>
			<td>����� ����</td>
			<td>��������</td>
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

				String sql = "SELECT STU_NO   		\n" +
				             "     , SCO_YEAR   	\n" +
				             "     , SCO_TERM  		\n" +
				             "     , REQ_PONUMBER 	\n" +
		            		 "     , TAKE_PONUMBER  \n" +
				             "     , EXAM_AVG  		\n" +
				             "     , EXAM_TOTAL 	\n" +
		            	     "     , SCO_DIV  		\n" +
				             "     , SCO_DATE 		\n" +
				             "  FROM SCORE"; // �����ų ���� ����
				
				System.out.println(sql);
				               
				rs = stmt.executeQuery(sql); // ���� �����Ͽ� ������ ����

				String stuNo; 			
				String scoYear; 		
				int    scoTerm;
				int    reqPonumber;
				int    takePonumber;
				int    examAvg;
				int    examTotal;
				String scoDiv;
				Timestamp scoDate; 	
  
				while (rs.next()) {
					stuNo         = rs.getString("STU_NO");
					scoYear 	  = rs.getString("SCO_YEAR");
					scoTerm       = rs.getInt("SCO_TERM");
					reqPonumber   = rs.getInt("REQ_PONUMBER");
					takePonumber  = rs.getInt("TAKE_PONUMBER");
					examAvg       = rs.getInt("EXAM_AVG");
					examTotal     = rs.getInt("EXAM_TOTAL");
					scoDiv 	      = rs.getString("SCO_DIV");
					scoDate 	  = rs.getTimestamp("SCO_DATE");
		%>
		<tr>
			<td><%=stuNo           %></td>
			<td><%=scoYear 		   %></td>
			<td><%=scoTerm         %></td>
			<td><%=reqPonumber     %></td>
			<td><%=takePonumber	   %></td>
			<td><%=examAvg         %></td>
			<td><%=examTotal       %></td>
			<td><%=scoDiv 	       %></td>
			<td><%=scoDate 	       %></td>
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