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
			<td>우편번호</td>
			<td>동이름</td>
			<td>주소</td>
			<td>전화지역번호</td>
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

				String sql = "SELECT POST_NO   \n" +
				             "     , POST_DONG   \n" +
				             "     , POST_ADDRESS  \n" +
				             "     , DDD \n" +
				             "  FROM POST"; // 실행시킬 쿼리 내용
				
				System.out.println(sql);
				               
				rs = stmt.executeQuery(sql); // 쿼리 실행하여 데이터 저장

				String postNo; 			
				String postDong; 		
				String postAddress; 		
				String ddd; 	

				while (rs.next()) {
					postNo       = rs.getString("POST_NO");
					postDong 	 = rs.getString("POST_DONG");
					postAddress  = rs.getString("POST_ADDRESS");
					ddd 		 = rs.getString("DDD");
		%>
		<tr>
			<td><%=postNo        %></td>
			<td><%=postDong 	 %></td>
			<td><%=postAddress   %></td>
			<td><%=ddd 		     %></td>
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