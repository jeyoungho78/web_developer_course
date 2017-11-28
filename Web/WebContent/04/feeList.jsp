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
			<td>��ϳ⵵</td>
			<td>����б�</td>
			<td>���б�</td>
			<td>��ϱ�(������)</td>
			<td>��ϱ��Ѿ�</td>
			<td>�����ڵ�</td>
			<td>���бݾ�</td>
			<td>�����Ѿ�</td>
			<td>��ϱ���</td>
			<td>��ϳ�¥</td>
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
				             "     , FEE_YEAR   \n" +
				             "     , FEE_TERM  \n" +
				             "     , FEE_ENTER \n" +
		            		 "     , FEE_PRICE   \n" +
				             "     , FEE_TOTAL  \n" +
				             "     , JANG_CODE \n" +
		            		 "     , JANG_TOTAL   \n" +
				             "     , FEE_PAY  \n" +
				             "     , FEE_DIV \n" +
				             "     , FEE_DATE \n" +
				             "  FROM FEE"; // �����ų ���� ����
				
				System.out.println(sql);
				               
				rs = stmt.executeQuery(sql); // ���� �����Ͽ� ������ ����

				String stuNo; 			
				String feeYear; 		
				int    feeTerm;
				int    feeEnter;
				int    feePrice;
				int    feeTotal;
				String jangCode;
				int    jangTotal;
				String feePay;
				String feeDiv;
				Timestamp feeDate; 	
  
				while (rs.next()) {
					stuNo         = rs.getString("STU_NO");
					feeYear 	  = rs.getString("FEE_YEAR");
					feeTerm       = rs.getInt("FEE_TERM");
					feeEnter      = rs.getInt("FEE_ENTER");
					feePrice 	  = rs.getInt("FEE_PRICE");
					feeTotal      = rs.getInt("FEE_TOTAL");
					jangCode      = rs.getString("JANG_CODE");
					jangTotal 	  = rs.getInt("JANG_TOTAL");
					feePay        = rs.getString("FEE_PAY");
					feeDiv 	      = rs.getString("FEE_DIV");
					feeDate 	  = rs.getTimestamp("FEE_DATE");
		%>
		<tr>
			<td><%=stuNo         %></td>
			<td><%=feeYear 		 %></td>
			<td><%=feeTerm       %></td>
			<td><%=feeEnter      %></td>
			<td><%=feePrice 	 %></td>
			<td><%=feeTotal    	 %></td>
			<td><%=jangCode      %></td>
			<td><%=jangTotal 	 %></td>
			<td><%=feePay        %></td>
			<td><%=feeDiv 	     %></td>
			<td><%=feeDate 	     %></td>
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