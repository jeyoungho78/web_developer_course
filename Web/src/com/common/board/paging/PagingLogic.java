package com.common.board.paging;

import java.sql.*;

import com.common.board.paging.*;

public class PagingLogic {
	PagingData pagingData;
	int totalContentCount;
	int perPageContentCount;
	int perPageViewPageCount;
	int selectedPage;

	public PagingData getPagingData() {
		return pagingData;
	}
	public void setPagingData(PagingData pagingData) {
		this.pagingData = pagingData;
	}
	
	public PagingLogic(PagingData pagingData) {
		this.pagingData = pagingData;
		totalContentCount = pagingData.getTotalContentCount();
		perPageContentCount = pagingData.getPerPageContentCount();
		perPageViewPageCount = pagingData.getPerPageViewPageCount();
		selectedPage = pagingData.getSelectedPage();
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
	
	public String makePageURL(int selectedPage) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("/BoardAction?cmd=list&totalContentCount=" + totalContentCount
				+ "&perPageContentCount=" + perPageContentCount + "&perPageViewPageCount="
				+ perPageViewPageCount + "&selectedPage=" + selectedPage);
		
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public String makeContentURL(int boardNum, int selectedPage) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("/BoardAction?cmd=view&boardNum=" + boardNum
				+ "&selectedPage=" + selectedPage);
		
		System.out.println(sb.toString());
		return sb.toString();
	}
}
