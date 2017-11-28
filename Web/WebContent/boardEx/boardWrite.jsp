<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%@ include file="./include/headInfo.html" %>
<title>Insert title here</title>
</head>
<body>
 <div class="wrap">
    <form action="/boardEx/boardWriteAction.jsp" method="GET">
      <div class="input_wrapper">
        <div class="title_wrap">
          <label for="title">제목</lable>
        </div>
        <div class="input_wrap">
          <input type="text" id="title" class="input_title" name="boardTitle">
        </div>
      </div>
      <div class="input_wrapper">
        <div class="title_wrap">
            <label for="name">작성자</lable>
        </div>
        <div class="input_wrap">
          <input type="text" id="name" name="boardWriter">
        </div>
      </div>
      <div class="cont_wrapper">
        <div class="title_wrap">
          <label for="content">내용</lable>
        </div>
        <textarea rows="10" cols="100" placeholder="내용입력" title="내용입력" id="content" name="boardContent"></textarea>
      </div>
      <div class="submit_wrapper">
        <input type="submit" value="확인" class="unrole_btn">
      </div>
    </form>
  </div>
</body>
</html>