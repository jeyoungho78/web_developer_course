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
	<form action="./departmentInsert.jsp" method ="get">
		<div align="center">
		<table>
			<tr>
				<td>학과코드</td>
				<td>:</td>
				<td><input type="text" name="deptCode"></td>
			</tr>
			<tr>
				<td>학과명</td>
				<td>:</td>
				<td><input type="text" name="deptName"></td>
			</tr>
			<tr>
				<td>학과영문명</td>
				<td>:</td>
				<td><input type="text" name="deptEname"></td>
			</tr>
			<tr>
				<td>생성일자</td>
				<td>:</td>
				<td><input type="text" name="createDate"></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="등록"></td>
			</tr>
			<%
				String deptCode = request.getParameter("deptCode");
				String deptName = request.getParameter("deptName");
				String deptEname = request.getParameter("deptEname");
				String createDate = request.getParameter("createDate");
				
				if(deptCode == null || deptName == null 
						|| deptEname == null || createDate == null){
					return;
				}
				
				System.out.println(deptCode);
				System.out.println(deptName);
				System.out.println(deptEname);
				System.out.println(createDate);
			%>
			
			<%@  include file="./dbConnectionInfo.jsp" %>
			
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
					/*
					sql = "SELECT COUNT(*) AS CNT   \n" +
					             "  FROM DEPARTMENT        \n" +
					             " WHERE DEPT_CODE = " + deptCode
					             ;
					System.out.println(sql);
			
					rs = stmt.executeQuery(sql);
					
					// 학과코드 중복 체크 
					int rowCnt = 0;		
					while (rs.next()) {
						rowCnt = rs.getInt("CNT");
						
						System.out.println("rowCnt : " + rowCnt);
						
						if(rowCnt > 0) {
							response.sendRedirect("./departmentInsert.jsp");
							return;
						}
					} 
					*/
					
					sql = "INSERT INTO DEPARTMENT    \n" +
			              "VALUES(" + deptCode + 
			                     ", '" + deptName + "'" +
			            		 ", '" + deptEname + "'" +
			            		 ", TO_DATE('" + createDate + "', 'YYYY/MM/DD')" +
			            		 ")"
					             ; // 실행시킬 쿼리 내용
			
					System.out.println(sql);
						             
					int result = stmt.executeUpdate(sql);
					if(result == 1){
						// 저장성공
						con.commit();
						response.sendRedirect("./departmentList.jsp");	
					} else {
						// 저장실패
						con.rollback();
						response.sendRedirect("./departmentInsert.jsp");
					}
			%>
			<%  } catch (Exception ex) {
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
		</div>
	</form>
</body>
</html>