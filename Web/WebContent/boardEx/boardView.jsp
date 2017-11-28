<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.net.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%@ include file="./include/headInfo.html" %>
<title>Insert title here</title>
</head>
<body>
<%  String selectedPage = (request.getParameter("selectedPage") == null? "" : request.getParameter("selectedPage"));
	String boardNum = (request.getParameter("boardNum") == null? "" : request.getParameter("boardNum"));
	
	// 요청 변수가 빈값일 경우 처리
	if (boardNum.equals("") || selectedPage.equals("")) {
		out.print("element is empty! please input data!");
		return;
	}
%>
<%@ include file="./include/dbConnectionInfo.jsp" %>
<% Connection con = null;
   Statement stmt = null;
   ResultSet rs = null;
	
   try {
	 	 Class.forName(driver); // 드라이버로드
		 con = DriverManager.getConnection(url, userid, passwd); // 데이터베이스에 연결
		 stmt = con.createStatement(); // 쿼리를 실행하기 위한 객체생성 
	     
		 String sql = "";
		 String sqlWhere = "";
		 if (!boardNum.equals("")){
			 sqlWhere = " WHERE 1=1              \n" + 
					    "   AND BOARD_NUM = " + boardNum; ;
		 }
		 
		 sql = "SELECT BOARD_NUM        \n" +     
			   "     , BOARD_TITLE      \n" +   
			   "     , BOARD_CONTENT    \n" +  
			   "     , BOARD_WRITER     \n" +   
			   "     , BOARD_CLICK_CNT  \n" + 
			   "     , CREATE_DATE      \n" +   
			   "     , DEL_YN           \n" + 
			   "  FROM BOARD            \n" + sqlWhere;
			   
		 System.out.println(sql);
		 
		 rs = stmt.executeQuery(sql);
		 	
		 //int rowNum;
	     //int boardNum;
	     String boardTitle;
	     String boardContent;
	     String boardWriter;
	     int boardClickCnt;
	     String createDate;
	     String delYn;
		 while(rs.next()){
	     	//rowNum = rs.getInt("RNUM");
	     	//boardNum = rs.getInt("BOARD_NUM");
	     	boardTitle = rs.getString("BOARD_TITLE");
	     	boardContent = rs.getString("BOARD_CONTENT");
	     	boardWriter = rs.getString("BOARD_WRITER");
	     	boardClickCnt = rs.getInt("BOARD_CLICK_CNT");
	     	createDate = rs.getString("CREATE_DATE");
	     	delYn = rs.getString("DEL_YN");
%>
  <div class="wrap">
    <div class="board_view">
        <ul>
          <li>
            <span class="post_title">제목</span>
            <span><%=boardTitle %></span>
          </li>
          <li>
            <span class="post_title">작성자</span>
            <span><%=boardWriter %></span>
          </li>
          <li>
            <span class="post_title">작성일</span>
            <span><%=createDate %></span>
          </li>
        </ul>
    </div>
    <div class="board_content"><%=boardContent %></div>
    <div class="unrole">
    	<a href="/boardEx/boardUpdate.jsp?selectedPage=<%=selectedPage %>&boardNum=<%=boardNum %>&boardTitle=<%=URLEncoder.encode(boardTitle) %>&boardWriter=<%=URLEncoder.encode(boardWriter) %>&boardContent=<%=URLEncoder.encode(boardContent) %>" title="글수정" class="unrole_btn"><span>수정</span></a>
    	<a href="/boardEx/boardDeleteAction.jsp?selectedPage=<%=selectedPage %>&boardNum=<%=boardNum %>" title="글삭제" class="unrole_btn"><span>삭제</span></a>
    	<a href="/boardEx/boardList.jsp?selectedPage=<%=selectedPage %>" title="글등록" class="unrole_btn"><span>목록</span></a>
    </div>
  </div>
  <% } // while  
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