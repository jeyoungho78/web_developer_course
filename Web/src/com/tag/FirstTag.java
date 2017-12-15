package com.tag;

import javax.servlet.jsp.tagext.TagSupport;

public class FirstTag extends TagSupport {
	public int doStartTag() { // doStartTag()를 오버라이딩
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 return SKIP_BODY; // Body 부분을 처리하지 않음.
		//return EVAL_BODY_INCLUDE; // Body 부분을 처리.
		
	}
}
