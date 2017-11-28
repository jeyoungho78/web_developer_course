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
			<td>교수번호</td>
			<td>교수명</td>
			<td>교수영문이름</td>
			<td>교수임용날짜</td>
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

				String sql = "SELECT PROF_CODE   \n" +
				             "     , PROF_NAME   \n" +
				             "     , PROF_ENAME  \n" +
				             "     , CREATE_DATE \n" +
				             "  FROM PROFESSOR"; // 실행시킬 쿼리 내용
				
				System.out.println(sql);
				               
				rs = stmt.executeQuery(sql); // 쿼리 실행하여 데이터 저장

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