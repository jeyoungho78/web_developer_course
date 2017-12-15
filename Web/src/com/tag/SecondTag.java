package com.tag;

import javax.servlet.jsp.tagext.TagSupport;

public class SecondTag extends TagSupport {
	String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int doStartTag() {
		try {
			pageContext.getOut().println(name + "님 안녕하세요");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY; // Body 부분을 처리하지 않음.
		//return EVAL_BODY_INCLUDE; // Body 부분을 처리.
	}
}
