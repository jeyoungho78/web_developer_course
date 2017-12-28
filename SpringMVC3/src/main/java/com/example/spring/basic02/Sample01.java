


package com.example.spring.basic02;

import java.util.*;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Sample01 {
	private Map map;
	private Properties props;
	private Set set;
	private List list;
	
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(
							new ClassPathResource("basic02/sample01.xml"));
		Sample01 instance = (Sample01)factory.getBean("sample01");
		instance.displayInfo();
	}
	
	public void setList(List list) {
		this.list = list;
	}
	
	public void setSet(Set set) {
		this.set = set;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
	
	public void setProps(Properties props) {
		this.props = props;
	}
	
	public void displayInfo() {
		
		Iterator i = map.keySet().iterator();
		
		System.out.println("Map 내용:\n");
		while(i.hasNext()) {
			Object key = i.next();
			System.out.println("key: " + key + " - value: " + map.get(key));
		}
		
		for(Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			Object key = it.next();
			System.out.println("key:: " + key + " - value:: " + map.get(key));
		}
		
		
		for(String key : new HashSet<String>(map.keySet())) {
			System.out.println("key::: " + key + " - value::: " + map.get(key));
		}
		
		// display the properties
		i = props.keySet().iterator();
		System.out.println("\n Properties 내용:\n");
		while(i.hasNext()) {
			String key = i.next().toString();
			System.out.println("key: " + key + " - value: " + props.getProperty(key));
		}
		
		// display the set
		i = set.iterator();
		System.out.println("\n Set 내용:\n");
		while(i.hasNext()) {
			System.out.println("Value: " + i.next());
		}
		
		// display the list
		i = list.iterator();
		System.out.println("\n List 내용:\n");
		while(i.hasNext()) {
			System.out.println("Value: " + i.next());
		}
		
	}
	
}
