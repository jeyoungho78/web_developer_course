package com.tag;

import javax.servlet.jsp.tagext.TagSupport;

public class FirstTag extends TagSupport {
	public int doStartTag() { // doStartTag()�� �������̵�
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 return SKIP_BODY; // Body �κ��� ó������ ����.
		//return EVAL_BODY_INCLUDE; // Body �κ��� ó��.
		
	}
}
