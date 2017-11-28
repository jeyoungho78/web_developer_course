<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.net.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%@ include file="./include/headInfo.html" %>
<title>Insert title here</title>
</head>
<body>
<%  String selectedPage = request.getParameter("selectedPage") == null? "" : request.getParameter("selectedPage");
    String boardNum = request.getParameter("boardNum") == null? "" : request.getParameter("boardNum");
	String boardTitle = URLDecoder.decode(request.getParameter("boardTitle")== null? "" : request.getParameter("boardTitle"), "UTF-8");
	String boardWriter = URLDecoder.decode(request.getParameter("boardWriter")== null? "" : request.getParameter("boardWriter"), "UTF-8");
	String boardContent = URLDecoder.decode(request.getParameter("boardContent")== null? "" : request.getParameter("boardContent"), "UTF-8");
%>
 <div class="wrap">
    <form action="/boardEx/boardUpdateAction.jsp" method="GET">
      <input type="hidden" id="selectedPage" name="selectedPage" value="<%=selectedPage %>">
      <input type="hidden" id="num" name="boardNum" value="<%=boardNum %>">
      <div class="input_wrapper">
        <div class="title_wrap">
          <label for="title">제목</lable>
        </div>
        <div class="input_wrap">
          <input type="text" id="title" class="input_title" name="boardTitle" value="<%=boardTitle %>">
        </div>
      </div>
      <div class="input_wrapper">
        <div class="title_wrap">
            <label for="name">작성자</lable>
        </div>
        <div class="input_wrap">
          <input type="text" id="name" name="boardWriter" value="<%=boardWriter %>">
        </div>
      </div>
      <div class="cont_wrapper">
        <div class="title_wrap">
          <label for="content">내용</lable>
        </div>
        <textarea rows="10" cols="100" placeholder="내용입력" title="내용입력" id="content" name="boardContent"><%=boardContent %></textarea>
      </div>
      <div class="submit_wrapper">
        <input type="submit" value="확인" class="unrole_btn">
      </div>
    </form>
  </div>
</body>
</html>