package com.boardEx.logic;

import java.sql.*;
import com.boardEx.data.PagingData;

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
	public int getContentStart() {
		int contentStart = (perPageContentCount * (selectedPage - 1)) + 1;
		
		System.out.println("contentStart : " + contentStart);
		return contentStart;
	}
	
	public int getContentEnd() {
		int contentEnd = perPageContentCount *  selectedPage; 
		
		System.out.println("contentEnd : " + contentEnd);
		return contentEnd;
	}
	
	public int getUnderViewPageStart() {
		int totalPageCount = getTotalPageCount();
		
		int underViewPageStart = 1;
		if (perPageViewPageCount < totalPageCount) {
			underViewPageStart = ((selectedPage - 1) / perPageViewPageCount) * perPageViewPageCount + 1;
		}
		
		System.out.println("underViewPageStart : " + underViewPageStart);
		return underViewPageStart;
	}
	
	public int getUnderViewPageEnd() {
		int totalPageCount = getTotalPageCount();
		
		int underViewPageEnd = totalPageCount;
		if (perPageViewPageCount < totalPageCount) {
			// 선택 페이지가 전체페이지의 마지막 페이지가 아닌 경우
			if ((totalPageCount / perPageViewPageCount) != ((selectedPage - 1) / perPageViewPageCount)) {
				underViewPageEnd = (((selectedPage - 1) / perPageViewPageCount) + 1) * perPageViewPageCount;
			}
		}
		
		System.out.println("underViewPageEnd : " + underViewPageEnd);
		return underViewPageEnd;
	}
	
	public int getTotalPageCount() {
		int totalPageCount = totalContentCount / perPageContentCount;
		int totalPageCountOverCheck = totalContentCount % perPageContentCount;

		if (totalPageCountOverCheck > 0) {
			totalPageCount = totalPageCount + 1;
		}
		
		System.out.println("totalPageCount : " + totalPageCount);
		return totalPageCount;
	}
	
	public String makeATag(int selectedPage) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("/boardEx/boardList.jsp?totalContentCount=" + totalContentCount
				+ "&perPageContentCount=" + perPageContentCount + "&perPageViewPageCount="
				+ perPageViewPageCount + "&selectedPage=" + selectedPage);
		
		System.out.println(sb.toString());
		return sb.toString();
	}
}
