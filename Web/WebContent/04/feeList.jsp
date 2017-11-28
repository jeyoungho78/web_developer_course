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
			<td>학번</td>
			<td>등록년도</td>
			<td>등록학기</td>
			<td>입학금</td>
			<td>등록금(수업료)</td>
			<td>등록금총액</td>
			<td>장학코드</td>
			<td>장학금액</td>
			<td>납부총액</td>
			<td>등록구분</td>
			<td>등록날짜</td>
		</tr>
		
		<%@  include file="./dbConnectionInfo.jsp" %>
		
		<%
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {
				
				Class.forName(driver); // 드라이버로드
				con = DriverManager.getConnection(url, userid, passwd); // 데이터베이스에 연결

				stmt = con.createStatement(); // 쿼리를 실행하기 위한 객체생성

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
				             "  FROM FEE"; // 실행시킬 쿼리 내용
				
				System.out.println(sql);
				               
				rs = stmt.executeQuery(sql); // 쿼리 실행하여 데이터 저장

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