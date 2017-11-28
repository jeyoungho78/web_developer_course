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
	    		<td colspan="5" align="right"><input type="button" onclick="location.href='./departmentInsert.jsp'" value="등록하기"><td>
	    	</tr>
			<tr>
				<td>학과번호</td>
				<td>학과명</td>
				<td>학과영문이름</td>
				<td>학과생성날짜</td>
				<td>학생정보보기</td>
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
	
					String sql = "SELECT DEPT_CODE   \n" +
					                  ", DEPT_NAME   \n" +
					                  ", DEPT_ENAME  \n" +
					                  ", CREATE_DATE \n" +
					               "FROM DEPARTMENT"; // 실행시킬 쿼리 내용
					
					System.out.println(sql);
					               
					rs = stmt.executeQuery(sql); // 쿼리 실행하여 데이터 저장
					
					int deptCode; // 컬럼명 : dept_code
					String deptName; // 컬럼명 : dept_name
					String deptEname; // 컬럼명 : dept_ename
					Timestamp createDate; // 컬럼명 : create_date
	
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
				<td><a href="./studentList.jsp?deptCode=<%=deptCode%>">학생정보보기</a></td>
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