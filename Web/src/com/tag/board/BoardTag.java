package com.tag.board;

import javax.servlet.jsp.tagext.TagSupport;

public class BoardTag extends TagSupport {
	String type;
	int pageNum;
	String pageNumURL;
	int selectedPage;
	int totalPageCount;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getPageNumURL() {
		return pageNumURL;
	}

	public void setPageNumURL(String pageNumURL) {
		this.pageNumURL = pageNumURL;
	}
	
	public int getSelectedPage() {
		return selectedPage;
	}

	public void setSelectedPage(int selectedPage) {
		this.selectedPage = selectedPage;
	}
	
	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	@Override
	public int doStartTag(){
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() {
		try {
			
			if(type.isEmpty()) {
				return SKIP_PAGE;
			}
			
			StringBuffer sb = new StringBuffer();
			switch(type) {
			case "PREV" :
				if(pageNum != 1) {
					sb.append("<a href=\"" + pageNumURL + "\" title=\"이전페이지\" id=\"ui_pgn_prev\" class=\"pgn_btn\"><span class=\"a11y_hidden\">이전페이지</span></a>\r\n");
				}
				break;
			case "PAGE" : 
				if(pageNum == selectedPage) {
					sb.append("<a href=\"" + pageNumURL + "\" id=\"pgn_a_" + pageNum + "\" class=\"ui_pgn_active\"><span class=\"a11y_hidden\">현재페이지</span><span>" + pageNum + "</span></a>\r\n");
				} else {
					sb.append("<a href=\"" + pageNumURL + "\" id=\"pgn_a_" + pageNum + "\"><span>" + pageNum + "</span></a>\r\n");
				}
				break;
			case "NEXT" : 
				if(pageNum != totalPageCount) {
					sb.append("<a href=\"" + pageNumURL + "\" title=\"다음페이지\" id=\"ui_pgn_next\" class=\"pgn_btn\"><span class=\"a11y_hidden\">다음페이지</span></a>");
				}
				break;
			}
			
			System.out.println("type : " + type);
			System.out.println("pageNum : " + pageNum);
			System.out.println("pageNumURL : " + pageNumURL);
			
			pageContext.getOut().println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return EVAL_PAGE;  
	}
}
