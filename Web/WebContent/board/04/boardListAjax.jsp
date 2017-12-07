<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="./include/headInfo.html" %>
<title>Insert title here</title>
</head>
<body>
<div class="wrap">
    <h2>게시판</h2>
    <form id = "frm_search" method="GET">
    <fieldset>
        <div class="search_form">
       	    <legend class="a11y_hidden">게시판 목록 검색</legend>
            <input type="hidden" name="cmd" value="list">
            <select id="select_field" name="field" title="분류선택">
            	<option value="">선택</option>
                <option value="BOARD_TITLE">제목</option>
                <option value="BOARD_WRITER">작성자</option>
                <option value="BOARD_CONTENT">내용</option>
            </select>
            <input id="search_word" name="searchWord" class="inp_type" title="검색어 입력" value="" type="text">
            <a href="#" class="inp_btn" onClick="chkSearchForm()"><span>검색하기</span></a>
        </div>
    </fieldset>
    </form>
    <table>
        <caption class="a11y_hidden">게시판으로 번호 제목 작성자 작성일 조회수를 나타내는 표</caption>
        <colgroup>
                <col style="width:10%">
                <col>
                <col style="width:15%">
                <col style="width:12%">
                <col style="width:9%">
                <col style="width:9%">
        </colgroup>
        <thead>
            <tr>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
                <th scope="col">글쓴이</th>
                <th scope="col">작성일</th>
                <th scope="col">조회수</th>
            </tr>
        </thead>
        <tbody>
        	<c:set var="boardListMap" value="${boardListMap}"></c:set>
        	
        	<%-- <c:set var="boardContentList" value="${boardListMap.boardContentList}"></c:set> --%>
        	<c:set var="pagingInfo" value="${boardListMap.pagingInfo}"></c:set>
        	<c:set var="pagingList" value="${boardListMap.pagingList}"></c:set>
        	
        	<%-- <c:forEach var="map" items="${boardContentList}">
	        	<c:set var="rowNum" value="${map.RNUM }"></c:set>
	        	<c:set var="boardNum" value="${map.BOARD_NUM }"></c:set>
	        	<c:set var="boardTitle" value="${map.BOARD_TITLE }"></c:set>
	        	<c:set var="boardContent" value="${map.BOARD_CONTENT }"></c:set>
	        	<c:set var="boardWriter" value="${map.BOARD_WRITER }"></c:set>
	        	<c:set var="boardClickCnt" value="${map.BOARD_CLICK_CNT }"></c:set>
	        	<fmt:parseDate var="createDate" value="${map.CREATE_DATE }" pattern="yyyyMMddHHmmss"></fmt:parseDate>
	        	<c:set var="delYn" value="${map.DEL_YN }"></c:set>
	        	<c:set var="boardContentURL" value="${map.BOARD_CONTENT_URL }"></c:set>	
        	
	            <tr>
	                <td>${rowNum }</td>
	                <th scope="row">
	                    <a href=${boardContentURL}>
	                    ${boardTitle }</a>
	                </th>
	                <td>${boardWriter }</td>
	                <td><fmt:formatDate value="${createDate}" pattern="yyyy/MM/dd"/></td>
	                <td>${boardClickCnt }</td>
	            </tr>
            
           </c:forEach> --%>
        </tbody>
    </table>
    <div class="unrole">
        <a href="/board/04/boardWrite.jsp" title="글등록" class="unrole_btn"><span>등록</span></a>
    </div>
    <div class="ui_page_navigator" role="navigation" aria-label="페이지 선택">
    	<%-- <c:set var="totalPageCount" value="${pagingInfo.totalPageCount}"></c:set>
    	<c:set var="underViewPageStart" value="${pagingInfo.underViewPageStart}"></c:set>
    	<c:set var="underViewPageEnd" value="${pagingInfo.underViewPageEnd}"></c:set>
    	<c:set var="selectedPage" value="${pagingInfo.selectedPage}"></c:set>
    	<c:set var="prePagingURL" value="${pagingInfo.prePagingURL}"></c:set>
    	<c:set var="nextPagingURL" value="${pagingInfo.nextPagingURL}"></c:set>
    	
    	<c:if test="${underViewPageStart != 1 }">
    		<a href="${prePagingURL}" title="이전페이지" id="ui_pgn_prev" class="pgn_btn"><span class="a11y_hidden">이전페이지</span></a>
    	</c:if>
    	    	
    	<c:forEach var="map" items="${pagingList}">
    		<c:set var="pageNum" value="${map.pageNum}"></c:set>
    		<c:set var="pageNumURL" value="${map.pageNumURL}"></c:set>
    		
    		<c:choose>
    			<c:when test="${pageNum == selectedPage}">
    				<a href="${pageNumURL}" id="pgn_a_${pageNum}" class="ui_pgn_active">
		            <span class="a11y_hidden">현재페이지</span>
		            <span>${pageNum}</span>
		        	</a>
    			</c:when>
    			<c:otherwise>
    				<a href="${pageNumURL}" id="pgn_a_${pageNum}">
    				<span>${pageNum}</span>
    				</a>
    			</c:otherwise>
    		</c:choose>
    	</c:forEach>  
    	  
    	<c:if test="${underViewPageEnd != totalPageCount }">
    		<a href="${nextPagingURL}" title="다음페이지" id="ui_pgn_next" class="pgn_btn"><span class="a11y_hidden">다음페이지</span></a>
    	</c:if>    --%>  
    </div>
</div>
</body>
<!-- 한글 깨짐 현상으로 여기다가 구현 -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(document).ready(loadBoardList(1));

    function loadBoardList(pageNum){
    	$.ajax({
    		type : "POST",
    		url : "/BoardAction?cmd=listAjax",
    		data : {"selectedPage" : pageNum},
    		dataType : "json",
    		success : function(data){
    			console.log("성공");
    			
    			// 페이지 컨텐츠 생성
    			$("table tbody:last > tr").remove();
    			var boardContentList = data.boardListMap.boardContentList;
    			$(boardContentList).each(function(index, element){
    				str = "<tr><td>" + element.RNUM  + "</td>" + 
    				  "<th scope=\"row\"><a href=" + element.BOARD_CONTENT_URL  + 
    				  ">" + element.BOARD_TITLE  +"</a></th>" +  
    				  "<td>" + element.BOARD_WRITER  + "</td>" + 
	    	          "<td>" + element.CREATE_DATE  + "</td>" + 
	    	          "<td>" + element.BOARD_CLICK_CNT  + "</td>" + 
	    	      "</tr>";
	    		$("table tbody:last").append(str);
    			});
    			
    			// 하단 페이징 생성
    			$("div.ui_page_navigator > a").remove();
    			var pagingInfo = data.boardListMap.pagingInfo;
    			var totalPageCount = pagingInfo.totalPageCount;
    			var underViewPageStart = pagingInfo.underViewPageStart;
    			var underViewPageEnd = pagingInfo.underViewPageEnd;
    			var selectedPage = pagingInfo.selectedPage;
    			var prePagingURL = pagingInfo.prePagingURL;
    			var nextPagingURL = pagingInfo.nextPagingURL;
    			
    			if(underViewPageStart != 1){
    				var prevA = $("<a></a>").attr("href", "#").attr("title", "이전페이지").attr("id", "ui_pgn_prev").attr("onclick", "loadBoardList(" +  (underViewPageStart - 1) + ")").addClass("pgn_btn");
    				var preSpan = $("<span></span>").addClass("a11y_hidden").text("이전페이지");
    				prevA.append(preSpan);    				
    				$("div.ui_page_navigator").append(prevA);
    			}
    			
    			var pagingList = data.boardListMap.pagingList;
    			$.each(pagingList, function(index, element){
    				var pageNum = element.pageNum;
    				var pageNumURL = element.pageNumURL;
    				
    				var pageA = $("<a></a>").attr("href", "#").attr("id", "pgn_a_" + pageNum).attr("onclick", "loadBoardList(" +  pageNum + ")");    				
    				
    				if(pageNum == selectedPage){
    					pageA.addClass("ui_pgn_active");
    					var pageSelSpan = $("<span></span>").addClass("a11y_hidden").text("현재페이지");
        				pageA.append(pageSelSpan);  
    				} 
    				
    				var pageSpan = $("<span></span>").text(pageNum);
					pageA.append(pageSpan);
					$("div.ui_page_navigator").append(pageA)
    			});
    			
    			if(underViewPageEnd != totalPageCount){
    				var nextA = $("<a></a>").attr("href", "#").attr("title", "다음페이지").attr("id", "ui_pgn_next").attr("onclick", "loadBoardList(" +  (underViewPageEnd + 1) + ")").addClass("pgn_btn");
    				var nextSpan = $("<span></span>").addClass("a11y_hidden").text("다음페이지");
    				nextA.append(nextSpan);    				
    				$("div.ui_page_navigator").append(nextA);
    			}
    			
    		},
    		error : function (xhr, status, error){
				console.log("에러발생 ");
				console.log("xhr : " + JSON.stringify(xhr));
				console.log("status : " + status);
				console.log("error : " + error);
			},
			complete : function (event, request, settings){
				console.log("완료");
				console.log("event : " + JSON.stringify(event));
				console.log("request : " + request);
				console.log("settings : " + settings);
			}
    	});
    }

    function chkSearchForm(){	
		if($("#select_field option:selected").text() == "선택"){
			alert("항목을 선택하세요.");
			return false;
		}
		
		if($("#search_word").val() == ""){
			alert("검색값을 입력하세요.");
			return false;
		}
		
		$("#frm_search").submit();
		
		return true;
	}
</script>
</html>