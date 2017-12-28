package com.example.spring.beantest;

import org.springframework.stereotype.Component;

@Component
public class SmsSender {
	
	boolean value = true;
	
	/*public SmsSender() {}*/
	
	/*public SmsSender(boolean value) {
		this.value = value;
	}*/

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
}
