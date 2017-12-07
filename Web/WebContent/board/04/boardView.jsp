<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
  <c:set var="delYn" value="${map.BOARD_TITLE}"></c:set>
</c:forEach>
  <div class="wrap">
    <div class="board_view">
        <ul>
          <li>
            <span class="post_title">제목</span>
            <span>${boardTitle }</span>
          </li>
          <li>
            <span class="post_title">작성자</span>
            <span>${boardWriter }</span>
          </li>
          <li>
            <span class="post_title">작성일</span>
            <span><fmt:formatDate value="${createDate}" pattern="yyyy/MM/dd"/></span>
          </li>
        </ul>
    </div>
    <div class="board_content">${boardContent }</div>
    <div class="file_wrap" name="fileWrap">
        <span class="post_title">첨부파일</span>
        <c:forEach var="map" items="${boardContentView}">
            <c:set var="fileNum" value="${map.FILE_NUM}"></c:set>
            <c:set var="filename" value="${map.SYS_NM}"></c:set>
            <c:set var="origfilename" value="${map.ORG_NM}"></c:set>
            <a href="/BoardAction?cmd=download&fileNum=${fileNum}&filename=${filename}&origfilename=${origfilename}">${origfilename }</a>
       	</c:forEach>
     </div>
    <div class="unrole">
    	<a href="/BoardAction?cmd=updateView&selectedPage=${selectedPage}&boardNum=${boardNum}" title="글수정" class="unrole_btn"><span>수정</span></a>
    	<a href="/BoardAction?cmd=delete&selectedPage=${selectedPage}&boardNum=${boardNum}" title="글삭제" class="unrole_btn"><span>삭제</span></a>
    	<a href="/BoardAction?cmd=list&selectedPage=${selectedPage}" title="글등록" class="unrole_btn"><span>목록</span></a>
    </div>
  </div>
</body>
</html>