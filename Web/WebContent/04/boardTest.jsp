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
	<%@  include file="./dbConnectionInfo.jsp"%>

	<%
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver); // 드라이버로드
			con = DriverManager.getConnection(url, userid, passwd); // 데이터베이스에 연결

			stmt = con.createStatement(); // 쿼리를 실행하기 위한 객체생성		
			con.setAutoCommit(false);

			String sql = "";

			for (int i = 1000; i > 0; i--) {

				sql = "INSERT INTO BOARDTEST    \n" + 
				      "VALUES(" + i + ")"; // 실행시킬 쿼리 내용

				System.out.println(sql);

				int result = stmt.executeUpdate(sql);
				if (result == 1) {
					// 저장성공
					con.commit();
				} else {
					// 저장실패
					con.rollback();
				}
			}
	%>
	<%
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
</body>
</html>