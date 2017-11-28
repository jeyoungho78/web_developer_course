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
    <h2>�Խ���</h2>
    <form id = "frm_search" method="GET">
    <fieldset>
        <div class="search_form">
       	    <legend class="a11y_hidden">�Խ��� ��� �˻�</legend>
            <input type="hidden" name="cmd" value="list">
            <select id="select_field" name="field" title="�з�����">
            	<option value="">����</option>
                <option value="BOARD_TITLE">����</option>
                <option value="BOARD_WRITER">�ۼ���</option>
                <option value="BOARD_CONTENT">����</option>
            </select>
            <input id="search_word" name="searchWord" class="inp_type" title="�˻��� �Է�" value="" type="text">
            <a href="#" class="inp_btn" onClick="chkSearchForm()"><span>�˻��ϱ�</span></a>
        </div>
    </fieldset>
    </form>
    <table>
        <caption class="a11y_hidden">�Խ������� ��ȣ ���� �ۼ��� �ۼ��� ��ȸ���� ��Ÿ���� ǥ</caption>
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
                <th scope="col">��ȣ</th>
                <th scope="col">����</th>
                <th scope="col">�۾���</th>
                <th scope="col">�ۼ���</th>
                <th scope="col">��ȸ��</th>
            </tr>
        </thead>
        <tbody>
        	<c:set var="boardListMap" value="${boardListMap}"></c:set>
        	
        	<c:set var="boardContentList" value="${boardListMap.boardContentList}"></c:set>
        	<c:set var="pagingInfo" value="${boardListMap.pagingInfo}"></c:set>
        	<c:set var="pagingList" value="${boardListMap.pagingList}"></c:set>
        	
        	<c:forEach var="map" items="${boardContentList}">
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
            
           </c:forEach>
        </tbody>
    </table>
    <div class="unrole">
        <a href="/board/03/boardWrite.jsp" title="�۵��" class="unrole_btn"><span>���</span></a>
    </div>
    <div class="ui_page_navigator" role="navigation" aria-label="������ ����">
    	<c:set var="totalPageCount" value="${pagingInfo.totalPageCount}"></c:set>
    	<c:set var="underViewPageStart" value="${pagingInfo.underViewPageStart}"></c:set>
    	<c:set var="underViewPageEnd" value="${pagingInfo.underViewPageEnd}"></c:set>
    	<c:set var="selectedPage" value="${pagingInfo.selectedPage}"></c:set>
    	<c:set var="prePagingURL" value="${pagingInfo.prePagingURL}"></c:set>
    	<c:set var="nextPagingURL" value="${pagingInfo.nextPagingURL}"></c:set>
    	
    	<c:if test="${underViewPageStart != 1 }">
    		<a href="${prePagingURL}" title="����������" id="ui_pgn_prev" class="pgn_btn"><span class="a11y_hidden">����������</span></a>
    	</c:if>
    	    	
    	<c:forEach var="map" items="${pagingList}">
    		<c:set var="pageNum" value="${map.pageNum}"></c:set>
    		<c:set var="pageNumURL" value="${map.pageNumURL}"></c:set>
    		
    		<c:choose>
    			<c:when test="${pageNum == selectedPage}">
    				<a href="${pageNumURL}" id="pgn_a_${pageNum}" class="ui_pgn_active">
		            <span class="a11y_hidden">����������</span>
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
    		<a href="${nextPagingURL}" title="����������" id="ui_pgn_next" class="pgn_btn"><span class="a11y_hidden">����������</span></a>
    	</c:if>     
    </div>
</div>
</body>
<!-- �ѱ� ���� �������� ����ٰ� ���� -->
<script type="text/javascript" src="../common/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function chkSearchForm(){	
		if($("#select_field option:selected").text() == "����"){
			alert("�׸��� �����ϼ���.");
			return false;
		}
		
		if($("#search_word").val() == ""){
			alert("�˻����� �Է��ϼ���.");
			return false;
		}
		
		$("#frm_search").submit();
		
		return true;
	}
</script>
</html>