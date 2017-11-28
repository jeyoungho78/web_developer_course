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
			<td>동아리가입번호</td>
			<td>동아리명</td>
			<td>학번</td>
			<td>이름</td>
			<td>대표</td>
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

				String sql = "SELECT CIR_NUM    \n" +
				             "     , CIR_NAME   \n" +
				             "     , STU_NO     \n" +
				             "     , STU_NAME   \n" +
				             "     , PRESIDENT  \n" +
				             "  FROM CIRCLE"; // 실행시킬 쿼리 내용
				
				System.out.println(sql);
				               
				rs = stmt.executeQuery(sql); // 쿼리 실행하여 데이터 저장
                
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