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
    <form action="">
	    <table>
	    	<tr>
	    		<td colspan="5" align="right"><input type="button" onclick="location.href='./departmentInsert.jsp'" value="����ϱ�"><td>
	    	</tr>
			<tr>
				<td>�а���ȣ</td>
				<td>�а���</td>
				<td>�а������̸�</td>
				<td>�а�������¥</td>
				<td>�л���������</td>
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
	
					String sql = "SELECT DEPT_CODE   \n" +
					                  ", DEPT_NAME   \n" +
					                  ", DEPT_ENAME  \n" +
					                  ", CREATE_DATE \n" +
					               "FROM DEPARTMENT"; // �����ų ���� ����
					
					System.out.println(sql);
					               
					rs = stmt.executeQuery(sql); // ���� �����Ͽ� ������ ����
					
					int deptCode; // �÷��� : dept_code
					String deptName; // �÷��� : dept_name
					String deptEname; // �÷��� : dept_ename
					Timestamp createDate; // �÷��� : create_date
	
					while (rs.next()) {
						deptCode = rs.getInt("DEPT_CODE");
						deptName = rs.getString("DEPT_NAME");
						deptEname = rs.getString("DEPT_ENAME");
						createDate = rs.getTimestamp("CREATE_DATE");
			%>
			<tr>
				<td><%=deptCode%></td>
				<td><%=deptName%></td>
				<td><%=deptEname%></td>
				<td><%=createDate%></td>
				<td><a href="./studentList.jsp?deptCode=<%=deptCode%>">�л���������</a></td>
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
	</form>
</body>
</html>