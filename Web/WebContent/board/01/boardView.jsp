<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.net.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%@ include file="./include/headInfo.html" %>
</head>
<body>
<% HashMap boardViewMap = (HashMap)request.getAttribute("boardViewMap");
   
   ArrayList boardContentView  = (ArrayList)((boardViewMap).get("boardContentView"));
   String selectedPage = (request.getParameter("selectedPage") == null? "" : request.getParameter("selectedPage"));
   String boardNum = (request.getParameter("boardNum") == null? "" : request.getParameter("boardNum"));
	
   String boardTitle;
   String boardContent;
   String boardWriter;
   int boardClickCnt;
   String createDate;
   String delYn;
   String boardContentURL;
   
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
   String year = "";
   String month = "";
   String day = "";
   String createdateParse = "";
   	
   for(int i = 0; i < boardContentView.size(); i++) {
   	
   	HashMap<String, String> map = (HashMap<String, String>)boardContentView.get(i);
   	
   	boardTitle    = map.get("BOARD_TITLE");
   	boardContent  = map.get("BOARD_CONTENT"); 
   	boardWriter   = map.get("BOARD_WRITER");
   	boardClickCnt = Integer.valueOf(map.get("BOARD_CLICK_CNT")); 
   	createDate    = map.get("CREATE_DATE");
   	delYn         = map.get("DEL_YN");
   	
   	year = createDate.substring(0, 4);
	month = createDate.substring(4, 6);
	day = createDate.substring(6, 8);
	createdateParse = year + "/" + month + "/" + day; 
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
            <span><%=sdf.format(sdf.parse(createdateParse)) %></span>
          </li>
        </ul>
    </div>
    <div class="board_content"><%=boardContent %></div>
    <div class="unrole">
    	<a href="/board/01/boardUpdate.jsp?selectedPage=<%=selectedPage %>&boardNum=<%=boardNum %>&boardTitle=<%=URLEncoder.encode(boardTitle) %>&boardWriter=<%=URLEncoder.encode(boardWriter) %>&boardContent=<%=URLEncoder.encode(boardContent) %>" title="글수정" class="unrole_btn"><span>수정</span></a>
    	<a href="/boardAction?cmd=delete&selectedPage=<%=selectedPage %>&boardNum=<%=boardNum %>" title="글삭제" class="unrole_btn"><span>삭제</span></a>
    	<a href="/boardAction?cmd=list&selectedPage=<%=selectedPage %>" title="글등록" class="unrole_btn"><span>목록</span></a>
    </div>
  </div>
<% } %>
</body>
</html>