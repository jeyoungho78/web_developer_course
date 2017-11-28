<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
        	<% 
        	     try{
	        		HashMap boardListMap = (HashMap)request.getAttribute("boardListMap");
	        	
	        		ArrayList boardList  = (ArrayList)((boardListMap).get("boardContentList"));
	        		HashMap   pagingInfo = (HashMap)((boardListMap).get("pagingInfo"));	
	        		ArrayList pagingList = (ArrayList)((boardListMap).get("pagingList"));
	        		
	        		int rowNum;
	   	     		int boardNum;
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
	        		
	        		for(int i = 0; i < boardList.size(); i++) {
	        			
	        			HashMap<String, String> map = (HashMap<String, String>)boardList.get(i);
	        			
	        			rowNum = Integer.valueOf(map.get("RNUM"));
	        			boardNum = Integer.valueOf(map.get("BOARD_NUM"));
	         			boardTitle = map.get("BOARD_TITLE");
	        			boardContent = map.get("BOARD_CONTENT"); 
	        			boardWriter = map.get("BOARD_WRITER");
	        			boardClickCnt = Integer.valueOf(map.get("BOARD_CLICK_CNT")); 
	        			createDate = map.get("CREATE_DATE");
	        			delYn = map.get("DEL_YN");
	        			boardContentURL = map.get("BOARD_CONTENT_URL");
	        			
	        			year = createDate.substring(0, 4);
	        			month = createDate.substring(4, 6);
	        			day = createDate.substring(6, 8);
	        			createdateParse = year + "/" + month + "/" + day; 
        	%>
            <tr>
                <td><%=rowNum %></td>
                <th scope="row">
                    <a href=<%=boardContentURL %>>
                    <%=boardTitle %></a>
                </th>
                <td><%=boardWriter %></td>
                <td><%=sdf.format(sdf.parse(createdateParse))%></td>
                <td><%=boardClickCnt %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <div class="unrole">
        <a href="/board/01/boardWrite.jsp" title="글등록" class="unrole_btn"><span>등록</span></a>
    </div>
    <div class="ui_page_navigator" role="navigation" aria-label="페이지 선택">
        <% int totalPageCount     = Integer.valueOf(pagingInfo.get("totalPageCount").toString());
           int underViewPageStart = Integer.valueOf(pagingInfo.get("underViewPageStart").toString());
		   int underViewPageEnd   = Integer.valueOf(pagingInfo.get("underViewPageEnd").toString());
		   int selectedPage       = Integer.valueOf(pagingInfo.get("selectedPage").toString());
		   String prePagingURL    = pagingInfo.get("prePagingURL").toString();
		   String nextPagingURL   = pagingInfo.get("nextPagingURL").toString();
		   
		   if (underViewPageStart != 1) {
        %>
			<a href="<%=prePagingURL %>" title="이전페이지" id="ui_pgn_prev" class="pgn_btn"><span class="a11y_hidden">이전페이지</span></a>
        <% }// if		
		   
		   int pageNum = 0;
           String pageNumURL = "";
           for(int i = 0; i < pagingList.size(); i++){
        	   HashMap<String, Object> map = (HashMap<String, Object>)pagingList.get(i);
        	   pageNum = Integer.valueOf(map.get("pageNum").toString());
        	   pageNumURL = map.get("pageNumURL").toString();
        %>
        <%    if(pageNum == selectedPage){ %>
        		 <a href="<%=pageNumURL %>" id="pgn_a_<%=pageNum %>" class="ui_pgn_active">
		            <span class="a11y_hidden">현재페이지</span>
		            <span><%=pageNum %></span>
		        </a>
        <% 	  }	else { %>
        		<a href="<%=pageNumURL %>" id="pgn_a_<%=pageNum %>"><span><%=pageNum %></span></a>
        <% 	  }//else
           }//for           
           if (underViewPageEnd != totalPageCount) {
        %>
    		<a href="<%=nextPagingURL %>" title="다음페이지" id="ui_pgn_next" class="pgn_btn"><span class="a11y_hidden">다음페이지</span></a>
    	<% } 
        }catch(Exception e) {
        	e.printStackTrace();
    	}
    	%>
    </div>
</div>
</body>
<script type="text/javascript">
	function chkSearchForm(){
		var objSel = document.getElementById('select_field');
		var objTxt = document.getElementById('search_word');
		var objfrm = document.getElementById('frm_search');
		
		var selIdx = objSel.options.selectedIndex;
		if(objSel.options[selIdx].text == "선택"){
			alert("항목을 선택하세요.");
			return false;
		}
		
		if(objTxt.value == ""){
			alert("검색값을 입력하세요.");
			return false;
		}
		
		objfrm.submit();
		
		return true;
	}
</script>
</html>