<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.boardEx.data.PagingData"%>
<%@ page import="com.boardEx.logic.PagingLogic"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.net.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="./include/headInfo.html" %>
<title>Insert title here</title>
</head>
<body>
<%  

%>
<%@ include file="./include/dbConnectionInfo.jsp" %>
<% Connection con = null;
   Statement stmt = null;
   ResultSet rs = null;
	
   try {
	 	 Class.forName(driver); // 드라이버로드
		 con = DriverManager.getConnection(url, userid, passwd); // 데이터베이스에 연결
		 stmt = con.createStatement(); // 쿼리를 실행하기 위한 객체생성 
	         
		 // 전체 컨텐츠 갯수 구하기 
		 String sql = "";
		 String sqlWhere = "";
		 sql = "SELECT COUNT(*) AS ROWCNT FROM BOARD";
		 System.out.println(sql);
		 
		 rs = stmt.executeQuery(sql);
		 
		 int rowCnt = 0;
		 while (rs.next()) {
		    rowCnt = rs.getInt("ROWCNT");
		 }
	  
		 int totalContentCount 		= Integer.valueOf(request.getParameter("totalContentCount") == null? "0" : request.getParameter("totalContentCount"));    // 전체 컨텐츠 개수
		 int perPageContentCount 	= Integer.valueOf(request.getParameter("perPageContentCount") == null? "0" : request.getParameter("perPageContentCount"));  // 페이지당 컨텐츠 개수
		 int perPageViewPageCount 	= Integer.valueOf(request.getParameter("perPageViewPageCount") == null? "0" : request.getParameter("perPageViewPageCount")); // 페이지당 보여질 페이지 개수
		 int selectedPage 			= Integer.valueOf(request.getParameter("selectedPage") == null? "0" : request.getParameter("selectedPage")); 		 // 선택된 페이지 
		 String field 			    = URLDecoder.decode(request.getParameter("field") == null? "" : request.getParameter("field"), "UTF-8");
		 String searchWord 			= URLDecoder.decode(request.getParameter("searchWord") == null? "" : request.getParameter("searchWord"), "UTF-8");
		 
		 System.out.println("----Before----");
		 System.out.println("totalContentCount : " + totalContentCount);
		 System.out.println("perPageContentCount : " + perPageContentCount);
		 System.out.println("perPageViewPageCount : " + perPageViewPageCount);
		 System.out.println("selectedPage : " + selectedPage);
		 
		 // 테스트용
		 totalContentCount = rowCnt;
		 perPageContentCount = 5;
		 perPageViewPageCount = 2;
		 if (selectedPage == 0) {
			 selectedPage = 1;
		 }
		 
		 System.out.println("----After-----");
		 System.out.println("totalContentCount : " + totalContentCount);
		 System.out.println("perPageContentCount : " + perPageContentCount);
		 System.out.println("perPageViewPageCount : " + perPageViewPageCount);
		 System.out.println("selectedPage : " + selectedPage);
		 
		 sqlWhere = "WHERE 1=1       \n" + "  AND DEL_YN = 'N'"; 
		 if (!field.equals("") || !searchWord.equals("")){
			 sqlWhere +=  "  AND " + field + " LIKE '%" + searchWord + "%'";
		 } 
		 
		 // 요청 변수가 빈값일 경우 처리
		 if (totalContentCount == 0 || perPageContentCount == 0  || totalContentCount == 0 
		 		|| perPageViewPageCount == 0 ) {
		 	out.print("element is empty! please input data!");
		 }

		 PagingLogic pl = null;
		
		 PagingData pd = new PagingData();
		 pd.setTotalContentCount(Integer.valueOf(totalContentCount));
		 pd.setPerPageContentCount(Integer.valueOf(perPageContentCount));
		 pd.setPerPageViewPageCount(Integer.valueOf(perPageViewPageCount));
		 pd.setSelectedPage(Integer.valueOf(selectedPage));
		
		 pl = new PagingLogic(pd);

%>
<div class="wrap">
    <h2>게시판</h2>
    <fieldset>
        <div class="search_form">
            <legend class="a11y_hidden">게시판 목록 검색</legend>
            <select name="field" title="분류선택">
                <option value="">선택</option>
                <option value="BOARD_TITLE">제목</option>
                <option value="BOARD_WRITER">작성자</option>
                <option value="BOARD_CONTENT">내용</option>
            </select>
            <input id="search_word" name="search_word" class="inp_type" title="검색어 입력" value="" type="text">
            <a href="#" class="inp_btn" onClick="return chkSearchForm(field, search_word, '<%=pl.makeATag(1) %>')"><span>검색하기</span></a>
        </div>
    </fieldset>
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
        	<%   // 선택 페이지의 컨텐츠 표시
	    		 int contentStart = (perPageContentCount * (selectedPage - 1)) + 1; // 선택한 페이지에서의 시작 컨텐츠 번호
	    		 int contentEnd   = (perPageContentCount *  selectedPage);          // 선택한 페이지에서의 마지막 컨텐츠 번호
	    		 
	    		 sql = "SELECT X.*                                \n" +
	    				  "  FROM(SELECT ROWNUM AS RNUM           \n" +
	    				  "            , BOARD_NUM                \n" +
	    				  "             , BOARD_TITLE             \n" +
	    				  "             , BOARD_CONTENT           \n" +
	    				  "             , BOARD_WRITER            \n" +
	    				  "             , BOARD_CLICK_CNT         \n" +
	    				  "             , CREATE_DATE             \n" +
	    				  "             , DEL_YN           		  \n" +
	    				  "         FROM (SELECT * FROM BOARD     \n" +
	    				  " 			      " + sqlWhere +     "\n" +
	    				  " 			ORDER BY BOARD_NUM DESC)  \n" + 
	    				  "        WHERE 1=1) X \n" +
	    				  "  WHERE 1=1 \n" +
	    				  "    AND RNUM >= " + contentStart + " AND RNUM <= " + contentEnd
	    				    ;
	    		 System.out.println(sql);
	    			
	    		 rs = stmt.executeQuery(sql); // 쿼리 실행하여 데이터 저장
	    		 
        	     int rowNum;
        	     int boardNum;
        	     String boardTitle;
        	     String boardContent;
        	     String boardWriter;
        	     int boardClickCnt;
        	     String createDate;
        	     String delYn;
        		 while(rs.next()){
        	     	rowNum = rs.getInt("RNUM");
        	     	boardNum = rs.getInt("BOARD_NUM");
        	     	boardTitle = rs.getString("BOARD_TITLE");
        	     	boardContent = rs.getString("BOARD_CONTENT");
        	     	boardWriter = rs.getString("BOARD_WRITER");
        	     	boardClickCnt = rs.getInt("BOARD_CLICK_CNT");
        	     	createDate = rs.getString("CREATE_DATE");
        	     	delYn = rs.getString("DEL_YN");
        	%>
        	
            <tr>
                <td><%=rowNum%></td>
                <th scope="row">
                    <a href="./boardView.jsp?boardNum=<%=boardNum%>&selectedPage=<%=selectedPage%>">
                    <%=boardTitle%></a>
                </th>
                <td><%=boardWriter%></td>
                <td><%=createDate%></td>
                <td><%=boardClickCnt%></td>
            </tr>        
            <% } // while %>
        </tbody>
    </table>
    <div class="unrole">
        <a href="/boardEx/boardWrite.jsp" title="글등록" class="unrole_btn"><span>등록</span></a>
    </div>
    <div class="ui_page_navigator" role="navigation" aria-label="페이지 선택">
        <% int totalPageCount     = pl.getTotalPageCount();
           int underViewPageStart = pl.getUnderViewPageStart();
		   int underViewPageEnd   = pl.getUnderViewPageEnd();
		   
		   if (underViewPageStart != 1) {
        %>
			<a href="<%=pl.makeATag(underViewPageStart - 1) %>" title="이전페이지" id="ui_pgn_prev" class="pgn_btn"><span class="a11y_hidden">이전페이지</span></a>
        <% }// if		
           for(int pageNum = underViewPageStart; pageNum <= underViewPageEnd; pageNum++){
        %>
        <%    if(pageNum == selectedPage){ %>
        		 <a href="<%=pl.makeATag(pageNum) %>" id="pgn_a_<%=pageNum %>" class="ui_pgn_active">
		            <span class="a11y_hidden">현재페이지</span>
		            <span><%=pageNum %></span>
		        </a>
        <% 	  }	else { %>
        		<a href="<%=pl.makeATag(pageNum) %>" id="pgn_a_<%=pageNum %>"><span><%=pageNum %></span></a>
        <% 	  }//else
           }//for           
           if ((perPageViewPageCount < totalPageCount) && underViewPageEnd != totalPageCount) {
        %>
    		<a href="<%=pl.makeATag(underViewPageEnd + 1) %>" title="다음페이지" id="ui_pgn_next" class="pgn_btn"><span class="a11y_hidden">다음페이지</span></a>
    	<% } %>
    </div>
</div>
<%  } catch (Exception ex) {
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
<script type="text/javascript">
	function chkSearchForm(objSel, objTxt, url){
		var selIdx = objSel.options.selectedIndex;
		if(objSel.options[selIdx].text == "선택"){
			alert("항목을 선택하세요.");
			return false;
		}
		
		if(objTxt.value == ""){
			alert("검색값을 입력하세요.");
			return false;
		}
		
		var hrefUrl = url + "&field=" + encodeURI(encodeURIComponent(objSel.options[selIdx].value))
	    			      + "&searchWord=" + encodeURI(encodeURIComponent(objTxt.value));

		location.href = hrefUrl;		
	}
</script>
</html>