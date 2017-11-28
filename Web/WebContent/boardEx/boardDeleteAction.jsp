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
<%  String selectedPage = request.getParameter("selectedPage") == null? "" : request.getParameter("selectedPage");
    String boardNum = request.getParameter("boardNum")== null? "" : request.getParameter("boardNum");
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
		Class.forName(driver); // 드라이버로드
		con = DriverManager.getConnection(url, userid, passwd); // 데이터베이스에 연결
		stmt = con.createStatement(); // 쿼리를 실행하기 위한 객체생성 
		
		String sql = "";
		String sqlWhere = "";
		sql = "UPDATE BOARD             						\n" + 
			  "   SET DEL_YN = 'Y'  							\n" +
			  " WHERE 1=1                 \n" +
			  "   AND BOARD_NUM = " + boardNum
			  ;
		System.out.println(sql);
		
		int result = stmt.executeUpdate(sql);
		if(result == 1){
			// 저장성공
			con.commit();
			response.sendRedirect("/boardEx/boardList.jsp?selectedPage=" + selectedPage);	
		} else {
			// 저장실패
			con.rollback();
			response.sendRedirect("/boardEx/boardList.jsp?selectedPage=" + selectedPage);
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