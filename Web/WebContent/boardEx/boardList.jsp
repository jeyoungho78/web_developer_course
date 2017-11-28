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
	 	 Class.forName(driver); // ����̹��ε�
		 con = DriverManager.getConnection(url, userid, passwd); // �����ͺ��̽��� ����
		 stmt = con.createStatement(); // ������ �����ϱ� ���� ��ü���� 
	         
		 // ��ü ������ ���� ���ϱ� 
		 String sql = "";
		 String sqlWhere = "";
		 sql = "SELECT COUNT(*) AS ROWCNT FROM BOARD";
		 System.out.println(sql);
		 
		 rs = stmt.executeQuery(sql);
		 
		 int rowCnt = 0;
		 while (rs.next()) {
		    rowCnt = rs.getInt("ROWCNT");
		 }
	  
		 int totalContentCount 		= Integer.valueOf(request.getParameter("totalContentCount") == null? "0" : request.getParameter("totalContentCount"));    // ��ü ������ ����
		 int perPageContentCount 	= Integer.valueOf(request.getParameter("perPageContentCount") == null? "0" : request.getParameter("perPageContentCount"));  // �������� ������ ����
		 int perPageViewPageCount 	= Integer.valueOf(request.getParameter("perPageViewPageCount") == null? "0" : request.getParameter("perPageViewPageCount")); // �������� ������ ������ ����
		 int selectedPage 			= Integer.valueOf(request.getParameter("selectedPage") == null? "0" : request.getParameter("selectedPage")); 		 // ���õ� ������ 
		 String field 			    = URLDecoder.decode(request.getParameter("field") == null? "" : request.getParameter("field"), "UTF-8");
		 String searchWord 			= URLDecoder.decode(request.getParameter("searchWord") == null? "" : request.getParameter("searchWord"), "UTF-8");
		 
		 System.out.println("----Before----");
		 System.out.println("totalContentCount : " + totalContentCount);
		 System.out.println("perPageContentCount : " + perPageContentCount);
		 System.out.println("perPageViewPageCount : " + perPageViewPageCount);
		 System.out.println("selectedPage : " + selectedPage);
		 
		 // �׽�Ʈ��
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
		 
		 // ��û ������ ���� ��� ó��
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
    <h2>�Խ���</h2>
    <fieldset>
        <div class="search_form">
            <legend class="a11y_hidden">�Խ��� ��� �˻�</legend>
            <select name="field" title="�з�����">
                <option value="">����</option>
                <option value="BOARD_TITLE">����</option>
                <option value="BOARD_WRITER">�ۼ���</option>
                <option value="BOARD_CONTENT">����</option>
            </select>
            <input id="search_word" name="search_word" class="inp_type" title="�˻��� �Է�" value="" type="text">
            <a href="#" class="inp_btn" onClick="return chkSearchForm(field, search_word, '<%=pl.makeATag(1) %>')"><span>�˻��ϱ�</span></a>
        </div>
    </fieldset>
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
        	<%   // ���� �������� ������ ǥ��
	    		 int contentStart = (perPageContentCount * (selectedPage - 1)) + 1; // ������ ������������ ���� ������ ��ȣ
	    		 int contentEnd   = (perPageContentCount *  selectedPage);          // ������ ������������ ������ ������ ��ȣ
	    		 
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
	    			
	    		 rs = stmt.executeQuery(sql); // ���� �����Ͽ� ������ ����
	    		 
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
        <a href="/boardEx/boardWrite.jsp" title="�۵��" class="unrole_btn"><span>���</span></a>
    </div>
    <div class="ui_page_navigator" role="navigation" aria-label="������ ����">
        <% int totalPageCount     = pl.getTotalPageCount();
           int underViewPageStart = pl.getUnderViewPageStart();
		   int underViewPageEnd   = pl.getUnderViewPageEnd();
		   
		   if (underViewPageStart != 1) {
        %>
			<a href="<%=pl.makeATag(underViewPageStart - 1) %>" title="����������" id="ui_pgn_prev" class="pgn_btn"><span class="a11y_hidden">����������</span></a>
        <% }// if		
           for(int pageNum = underViewPageStart; pageNum <= underViewPageEnd; pageNum++){
        %>
        <%    if(pageNum == selectedPage){ %>
        		 <a href="<%=pl.makeATag(pageNum) %>" id="pgn_a_<%=pageNum %>" class="ui_pgn_active">
		            <span class="a11y_hidden">����������</span>
		            <span><%=pageNum %></span>
		        </a>
        <% 	  }	else { %>
        		<a href="<%=pl.makeATag(pageNum) %>" id="pgn_a_<%=pageNum %>"><span><%=pageNum %></span></a>
        <% 	  }//else
           }//for           
           if ((perPageViewPageCount < totalPageCount) && underViewPageEnd != totalPageCount) {
        %>
    		<a href="<%=pl.makeATag(underViewPageEnd + 1) %>" title="����������" id="ui_pgn_next" class="pgn_btn"><span class="a11y_hidden">����������</span></a>
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
		if(objSel.options[selIdx].text == "����"){
			alert("�׸��� �����ϼ���.");
			return false;
		}
		
		if(objTxt.value == ""){
			alert("�˻����� �Է��ϼ���.");
			return false;
		}
		
		var hrefUrl = url + "&field=" + encodeURI(encodeURIComponent(objSel.options[selIdx].value))
	    			      + "&searchWord=" + encodeURI(encodeURIComponent(objTxt.value));

		location.href = hrefUrl;		
	}
</script>
</html>