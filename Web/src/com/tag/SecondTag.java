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
			pageContext.getOut().println(name + "�� �ȳ��ϼ���");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY; // Body �κ��� ó������ ����.
		//return EVAL_BODY_INCLUDE; // Body �κ��� ó��.
	}
}
