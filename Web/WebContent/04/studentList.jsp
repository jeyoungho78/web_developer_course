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
			<td>�й�</td>
			<td>�л��̸�</td>
			<td>�����̸�</td>
			<td>�а��ڵ�</td>
			<td>�г�</td>
			<td>��</td>
			<td>�־߱���</td>
			<td>�ֹε�Ϲ�ȣ</td>
			<td>�����ȣ</td>
			<td>�ּ�</td>
			<td>��ȭ��ȣ</td>
			<td>�޴���ȭ��ȣ</td>
			<td>����⵵</td>
			<td>�а���</td>
		</tr>

		<%@  include file="./dbConnectionInfo.jsp"%>

		<%
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {
				String rqDeptCode = request.getParameter("deptCode");
				
				Class.forName(driver); // ����̹��ε�
				con = DriverManager.getConnection(url, userid, passwd); // �����ͺ��̽��� ����

				stmt = con.createStatement(); // ������ �����ϱ� ���� ��ü����
				
				// �����ų ���� ����
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
							   
				rs = stmt.executeQuery(sql); // ���� �����Ͽ� ������ ����

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