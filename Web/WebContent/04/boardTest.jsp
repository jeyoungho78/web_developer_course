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

			Class.forName(driver); // ����̹��ε�
			con = DriverManager.getConnection(url, userid, passwd); // �����ͺ��̽��� ����

			stmt = con.createStatement(); // ������ �����ϱ� ���� ��ü����		
			con.setAutoCommit(false);

			String sql = "";

			for (int i = 1000; i > 0; i--) {

				sql = "INSERT INTO BOARDTEST    \n" + 
				      "VALUES(" + i + ")"; // �����ų ���� ����

				System.out.println(sql);

				int result = stmt.executeUpdate(sql);
				if (result == 1) {
					// ���强��
					con.commit();
				} else {
					// �������
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