package com.boardEx.data;

public class PagingData {
	int totalContentCount;
	int perPageContentCount;
	int perPageViewPageCount;
	int selectedPage;
	
	public int getTotalContentCount() {
		return totalContentCount;
	}
	public void setTotalContentCount(int totalContentCount) {
		this.totalContentCount = totalContentCount;
	}
	public int getPerPageContentCount() {
		return perPageContentCount;
	}
	public void setPerPageContentCount(int perPageContentCount) {
		this.perPageContentCount = perPageContentCount;
	}
	public int getPerPageViewPageCount() {
		return perPageViewPageCount;
	}
	public void setPerPageViewPageCount(int perPageViewPageCount) {
		this.perPageViewPageCount = perPageViewPageCount;
	}
	public int getSelectedPage() {
		return selectedPage;
	}
	public void setSelectedPage(int selectedPage) {
		this.selectedPage = selectedPage;
	}
	
}
