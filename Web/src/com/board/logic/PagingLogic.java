package com.board.logic;

import java.sql.*;
import com.board.data.PagingData;

public class PagingLogic {
	PagingData pd;
	int totalContentCount;
	int perPageContentCount;
	int perPageViewPageCount;
	int selectedPage;
	
	public PagingLogic(PagingData pd) {
		this.pd = pd;
		totalContentCount = pd.getTotalContentCount();
		perPageContentCount = pd.getPerPageContentCount();
		perPageViewPageCount = pd.getPerPageViewPageCount();
		selectedPage = pd.getSelectedPage();
	}
	
  /*public String getListContentNumber(Statement stmt, ResultSet rs) throws Exception{
		StringBuffer sb = new StringBuffer();
		
		// 총 페이지수 구하기
		int totalPageCount = totalContentCount / perPageContentCount;
		int totalPageCountOverCheck = totalContentCount % perPageContentCount;

		if (totalPageCountOverCheck > 0) {
			totalPageCount = totalPageCount + 1;
		}
		
		// 선택 페이지의 컨텐츠 표시
		//int contentStart = totalContentCount - (perPageContentCount * (selectedPage - 1));
		//int contentEnd = totalContentCount - (perPageContentCount * selectedPage) + 1;
		
		int contentStart = (perPageContentCount * (selectedPage - 1)) + 1;
		int contentEnd   = (perPageContentCount *  selectedPage);
		
		//쿼리문 
		String sql = "SELECT X.*                   \n" +
					 "  FROM                       \n" +
					 "     (SELECT ROWNUM AS RNUM  \n" + 
					 "           , NUM_CODE        \n" +
					 "        FROM BOARDTEST       \n" +
					 "       WHERE 1=1             \n" +  
					 "         AND ROWNUM <= "+ contentEnd + "\n" + 
					 "    ORDER BY NUM_CODE DESC) X\n" + 
					 " WHERE 1=1                   \n" + 
					 "   AND RNUM >= " + contentStart + " AND RNUM <= " + contentEnd
					; // 실행시킬 쿼리 내용

		System.out.println(sql);
		             
		rs = stmt.executeQuery(sql); // 쿼리 실행하여 데이터 저장
		
		int rowNum;  // 
		int numCode; // 

		sb.append("<table>" + "\n");
		
		//for (int num = contentStart; num >= contentEnd; num--) {
		while(rs.next()) {
			rowNum = rs.getInt("RNUM");
			numCode = rs.getInt("NUM_CODE");
			
			sb.append("    <tr>" + "\n");
			
			if (rowNum <= 0) {
				sb.append("        <td></td>" + "\n");
			} else {
				sb.append("        <td>" + rowNum + "</td>" + "\n");
				sb.append("        <td>" + numCode + "</td>" + "\n");
			}
			
			sb.append("    </tr>" + "\n");
		}

		sb.append("</table>" + "\n");
		
		System.out.println(sb.toString());
		
		return sb.toString();
	}*/
	
	public String getListContentNumber(Statement stmt, ResultSet rs) throws Exception{
		StringBuffer sb = new StringBuffer();
		
		// 선택 페이지의 컨텐츠 표시
		int contentStart = (perPageContentCount * (selectedPage - 1)) + 1;
		int contentEnd   = (perPageContentCount *  selectedPage);
		
		//쿼리문 
		String sql = "SELECT X.*                   \n" +
					 "  FROM                       \n" +
					 "     (SELECT ROWNUM AS RNUM  \n" + 
					 "           , NUM_CODE        \n" +
					 "        FROM (SELECT * FROM BOARDTEST ORDER BY  NUM_CODE DESC) \n" +
					 "       WHERE 1=1             \n" +  
					 "         AND ROWNUM <= "+ contentEnd + "\n" + 
					 "    ORDER BY NUM_CODE DESC) X\n" + 
					 " WHERE 1=1                   \n" + 
					 "   AND RNUM >= " + contentStart + " AND RNUM <= " + contentEnd
					; // 실행시킬 쿼리 내용

		System.out.println(sql);
		rs = stmt.executeQuery(sql); // 쿼리 실행하여 데이터 저장
		
		int rowNum;  
		int numCode; 
		
		sb.append("<table>" + "\n");
		while(rs.next()) {
			rowNum = rs.getInt("RNUM");
			numCode = rs.getInt("NUM_CODE");
			
			sb.append("    <tr>" + "\n");
			if (rowNum <= 0) {
				sb.append("        <td colspan=\"2\"></td>" + "\n");
			} else {
				sb.append("        <td>" + rowNum + "</td>" + "\n");
				sb.append("        <td>" + numCode + "</td>" + "\n");
			}
			sb.append("    </tr>" + "\n");
		}
		sb.append("</table>" + "\n");
		System.out.println(sb.toString());
		
		return sb.toString();
	}
	
	public String getUnderPagingNumber() {
		StringBuffer sb = new StringBuffer();
		
		// 총 페이지수 구하기
		int totalPageCount = totalContentCount / perPageContentCount;
		int totalPageCountOverCheck = totalContentCount % perPageContentCount;

		if (totalPageCountOverCheck > 0) {
			totalPageCount = totalPageCount + 1;
		}
		
		System.out.println("totalPageCount : " + totalPageCount);
		
		int underViewPageStart = 1;
		int underViewPageEnd = totalPageCount;

		if (perPageViewPageCount < totalPageCount) {
			underViewPageStart = ((selectedPage - 1) / perPageViewPageCount) * perPageViewPageCount + 1;

			// 선택 페이지가 전체페이지의 마지막 페이지가 아닌 경우
			if ((totalPageCount / perPageViewPageCount) != ((selectedPage - 1) / perPageViewPageCount)) {
				underViewPageEnd = (((selectedPage - 1) / perPageViewPageCount) + 1) * perPageViewPageCount;
			}
		}

		System.out.println("underViewPageStart : " + underViewPageStart);
		System.out.println("underViewPageEnd : " + underViewPageEnd);

		if (underViewPageStart != 1) {
			sb.append(makeATag((underViewPageStart - 1), "&#9664; " ));
		}
		for (int page = underViewPageStart; page <= underViewPageEnd; page++) {
			if (page == selectedPage) {
				sb.append("[" + page + "] ");
			} else {
				sb.append(makeATag(page, String.valueOf(page)));
				sb.append(" ");
			}
		}
		if ((perPageViewPageCount < totalPageCount) && underViewPageEnd != totalPageCount) {
			sb.append(makeATag((underViewPageEnd + 1), " &#9654;"));
		}
		
		return sb.toString();
	}
	
   /*	
    int getTotalPageCount() {
		int totalPageCount = totalContentCount / perPageContentCount;
		int totalPageCountOverCheck = totalContentCount % perPageContentCount;

		if (totalPageCountOverCheck > 0) {
			totalPageCount = totalPageCount + 1;
		}
		
		return totalPageCount;
	}*/
	
	String makeATag(int selectedPage, String content) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("<a href=\"/board/pagingExec.jsp?totalContentCount=" + totalContentCount
				+ "&perPageContentCount=" + perPageContentCount + "&perPageViewPageCount="
				+ perPageViewPageCount + "&selectedPage=" + selectedPage + "\">");
		sb.append(content);
		sb.append("</a>");
		
		return sb.toString();
	}
}
