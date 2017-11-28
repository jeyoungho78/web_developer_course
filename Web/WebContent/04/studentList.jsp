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
			<td>학생이름</td>
			<td>영문이름</td>
			<td>학과코드</td>
			<td>학년</td>
			<td>반</td>
			<td>주야구분</td>
			<td>주민등록번호</td>
			<td>우편번호</td>
			<td>주소</td>
			<td>전화번호</td>
			<td>휴대전화번호</td>
			<td>출생년도</td>
			<td>학과명</td>
		</tr>

		<%@  include file="./dbConnectionInfo.jsp"%>

		<%
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {
				String rqDeptCode = request.getParameter("deptCode");
				
				Class.forName(driver); // 드라이버로드
				con = DriverManager.getConnection(url, userid, passwd); // 데이터베이스에 연결

				stmt = con.createStatement(); // 쿼리를 실행하기 위한 객체생성
				
				// 실행시킬 쿼리 내용
				String sql = "SELECT S.STU_NO      \n" + 
						     "     , S.STU_NAME    \n" + 
						     "     , S.STU_ENAME   \n" + 
							 "     , S.DEPT_CODE   \n" + 
				             "     , S.GRADE 	   \n" + 
						     "     , S.CLASS 	   \n" + 
				             "     , S.JUYA 	   \n" + 
							 "     , S.ID_NUM 	   \n" + 
				             "     , S.POST_NO 	   \n" + 
							 "     , S.ADDRESS 	   \n" + 
				             "     , S.TEL 		   \n" + 
							 "     , S.PHONE_NO    \n" + 
				             "     , S.BIRTH_YEAR  \n" + 
				             "     , D.DEPT_NAME   \n" +
							 "  FROM STUDENT S     \n" +
							 "     , DEPARTMENT D  \n" +
							 " WHERE 1=1           \n" +
   							 "   AND S.DEPT_CODE = D.DEPT_CODE \n";
                 
				//if(!rqDeptCode.equals("")){
				if(rqDeptCode != null){
                	  sql += "   AND D.DEPT_CODE = " + rqDeptCode + " \n"; 
                 }
   					
				System.out.println(sql);			   
							   
				rs = stmt.executeQuery(sql); // 쿼리 실행하여 데이터 저장

				String stuNo;
				String stuName;
				String stuEname;
				int deptCode;
				int grade;
				int stuClass;
				String juya;
				String idNum;
				String postNo;
				String address;
				String tel;
				String phoneNo;
				String birthYear;
				String deptName;

				while (rs.next()) {
					stuNo     = rs.getString("STU_NO");
					stuName   = rs.getString("STU_NAME");
					stuEname  = rs.getString("STU_ENAME");
					deptCode  = rs.getInt("DEPT_CODE");
					grade     = rs.getInt("GRADE");
					stuClass  = rs.getInt("CLASS");
					juya      = rs.getString("JUYA");
					idNum     = rs.getString("ID_NUM");
					postNo    = rs.getString("POST_NO");
					address   = rs.getString("ADDRESS");
					tel       = rs.getString("TEL");
					phoneNo   = rs.getString("PHONE_NO");
					birthYear = rs.getString("BIRTH_YEAR");
					deptName  = rs.getString("DEPT_NAME");
		%>
		<tr>
			<td><%=stuNo     %></td>
			<td><%=stuName   %></td>
			<td><%=stuEname  %></td>
			<td><%=deptCode  %></td>
			<td><%=grade     %></td>
			<td><%=stuClass  %></td>
			<td><%=juya      %></td>
			<td><%=idNum     %></td>
			<td><%=postNo    %></td>
			<td><%=address   %></td>
			<td><%=tel       %></td>
			<td><%=phoneNo   %></td>
			<td><%=birthYear %></td>
			<td><%=deptName  %></td>
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