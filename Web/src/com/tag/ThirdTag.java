package com.tag;

import javax.servlet.jsp.tagext.TagSupport;

public class ThirdTag extends TagSupport {
	
	int count = 0;
	public int doStartTag() { // doStartTag()�� �������̵�
		try {
			System.out.println("doStartTag()");
			pageContext.getOut().println("doStartTag() : ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//return SKIP_BODY; // Body �κ��� ó������ ����.
		return EVAL_BODY_INCLUDE; // Body �κ��� ó��.
	}
	
	public int doAfterBody() { // doAfterBody()�� �������̵�
		if(count < 5) {
			count++;
			try {
				pageContext.getOut().println("<br>doAfterBody() count : " + count);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return EVAL_BODY_AGAIN;
		} else {
			//return SKIP_BODY; 
			return SKIP_BODY; 
		}
	}
	
	public int doEndTag(){
		try {
			System.out.println("doEndTag");
			pageContext.getOut().println("<br>doEndTag");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;  // �±� �Ʒ��κ� �ڵ� ����.
		//return SKIP_PAGE; // �±� �Ʒ��κ� �ڵ� ���� ����.
	}
}
