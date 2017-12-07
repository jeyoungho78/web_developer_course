<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.net.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%@ include file="./include/headInfo.html" %>
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="/board/04/js/board.js"></script>
</head>
<body>
<c:set var="selectedPage" value="${param.selectedPage}"></c:set>
<c:set var="boardNum" value="${param.boardNum}"></c:set>

<c:set var="boardViewMap" value="${boardViewMap}"></c:set>
<c:set var="boardContentView" value="${boardViewMap.boardContentView}"></c:set>

<c:forEach var="map" items="${boardContentView}" begin="0" end="1" step="1">
  <c:set var="boardTitle" value="${map.BOARD_TITLE}"></c:set>
  <c:set var="boardContent" value="${map.BOARD_CONTENT}"></c:set>
  <c:set var="boardWriter" value="${map.BOARD_WRITER}"></c:set>
  <c:set var="boardClickCnt" value="${map.BOARD_CLICK_CNT}"></c:set>
  <fmt:parseDate var="createDate" value="${map.CREATE_DATE }" pattern="yyyyMMddHHmmss"></fmt:parseDate>
  <c:set var="delYn" value="${map.DEL_YN}"></c:set>
</c:forEach>

 <div class="wrap">
    <form action="/BoardAction" method="GET">
      <input type="hidden" id="selectedPage" name="selectedPage" value="${selectedPage}">
      <input type="hidden" id="boardNum" name="boardNum" value="${boardNum}">
      <input type="hidden" id="delFileNum" name="delFileNum">
      <input type="hidden" id="cmd" name="cmd" value="update">
      <div class="input_wrapper">
        <div class="title_wrap">
          <label for="title">제목</lable>
        </div>
        <div class="input_wrap">
          <input type="text" id="title" class="input_title" name="boardTitle" value="${boardTitle}">
        </div>
      </div>
      <div class="input_wrapper">
        <div class="title_wrap">
            <label for="name">작성자</lable>
        </div>
        <div class="input_wrap">
          <input type="text" id="name" name="boardWriter" value="${boardWriter}">
        </div>
      </div>
      <div class="cont_wrapper">
        <div class="title_wrap">
          <label for="content">내용</lable>
        </div>
        <textarea rows="10" cols="100" placeholder="내용입력" title="내용입력" id="content" name="boardContent">${boardContent}</textarea>
      </div>
      <div class="inpute_wrapper">
	    <div class="title_wrap">
	      <label for="file">파일</label>
	    </div>
	    <div class="input_wrap">
	      <button type="button" class="unrole_btn" onclick="addFileInp()">추가</button>
	      <button type="button" class="unrole_btn" onclick="deleteInp()">삭제</button>
	    </div>
	  </div>
	  <div id="file_area">
	  	<c:forEach var="map" items="${boardContentView}" varStatus="status">
            <c:set var="fileNum" value="${map.FILE_NUM}"></c:set>
            <c:set var="filename" value="${map.SYS_NM}"></c:set>
            <c:set var="origfilename" value="${map.ORG_NM}"></c:set>
            <div class="file_wrap" name="fileInput" value="${fileNum}">
            	${origfilename}
            	<a href="#" name="delFile">
            		<span style="background-color:#666; color:#fff;padding:2px 4px; font-size:9px; border-radius: 2px; font-weight:bold;">
            		 X
            		</span>
            	</a>
           </div>
       	</c:forEach>
	  </div>  
      <div class="submit_wrapper">
        <input type="submit" value="확인" class="unrole_btn">
      </div>
    </form>
  </div>
</body>
<script type="text/javascript">
	var delFile = $("[name='delFile']");
	delFile.click(function(){
	    var parent = $(this).parent();
	    var fileNum = parent.attr('value');
	    //$("#delFileNum").val(fileNum);
	    parent.remove();
		//alert("1");
	});
	
</script>
</html>