package com.example.spring.basic02;

import java.util.*;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Sample03 {
	
	public static void main(String[] args) {
		XmlBeanFactory bf = 
				new XmlBeanFactory(new ClassPathResource("basic02/sample03.xml"));
		
		B b = (B)bf.getBean("b");
		A a = (A)bf.getBean("a");
		
		System.out.println(b);
		System.out.println(a);
	}
}
