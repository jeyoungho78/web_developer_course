<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="com.google.gson.*"%>
<%@ page import="com.google.gson.internal.LinkedTreeMap"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@  include file="./dbConnectionInfo.jsp" %>
	
	<%
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList list = new ArrayList();
		
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
				
				HashMap<String, String> mapData = new HashMap<String, String>();
				mapData.put("DEPT_CODE", String.valueOf(deptCode));
				mapData.put("DEPT_NAME", deptName);
				mapData.put("DEPT_ENAME", deptEname);
				mapData.put("CREATE_DATE", String.valueOf(createDate));
				list.add(mapData);
			} //while 
			
			request.setAttribute("list", list);
			
			String jsonUrl = "/ajax/departmentListJsonView.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(jsonUrl);
			rd.forward(request, response);
			
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