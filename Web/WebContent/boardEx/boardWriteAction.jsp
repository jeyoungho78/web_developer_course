<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%@ include file="./include/headInfo.html"%>
<title>Insert title here</title>
</head>
<body>
<%
	String boardTitle = request.getParameter("boardTitle")== null? "" : request.getParameter("boardTitle");
	String boardWriter = request.getParameter("boardWriter")== null? "" : request.getParameter("boardWriter");
	String boardContent = request.getParameter("boardContent")== null? "" : request.getParameter("boardContent");
%>
<%@ include file="./include/dbConnectionInfo.jsp"%>
<%
   Connection con = null;
   Statement stmt = null;
   ResultSet rs = null;

   try {
		Class.forName(driver); // ����̹��ε�
		con = DriverManager.getConnection(url, userid, passwd); // �����ͺ��̽��� ����
		stmt = con.createStatement(); // ������ �����ϱ� ���� ��ü���� 
		
		String sql = "";
		String sqlWhere = "";
		sql = "SELECT NVL(MAX(BOARD_NUM), 1) + 1 AS NEW_BOARD_NUM FROM BOARD";
		System.out.println(sql);

		rs = stmt.executeQuery(sql);

		int newBoardNum = 1;
		while (rs.next()) {
			newBoardNum = rs.getInt("NEW_BOARD_NUM");
		}
		
		sql = "INSERT INTO BOARD VALUES \n" + 
		      "(" + newBoardNum  + ",  '" +  
		    		boardTitle   + "', '" +  
		    		boardContent + "', '" +
		    	    boardWriter  + "', "  + 
		            0            + ", " + 
		    		"TO_CHAR(SYSDATE, 'YYYYMMDDHHMISS')" + ", '" + 
		            "N" + "')";
		System.out.println(sql);
		
		int result = stmt.executeUpdate(sql);
		if(result == 1){
			// ���强��
			con.commit();
			response.sendRedirect("/boardEx/boardList.jsp");	
		} else {
			// �������
			con.rollback();
			response.sendRedirect("/boardEx/boardList.jsp");
		}

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
	} // finally
%>
</body>
</html>