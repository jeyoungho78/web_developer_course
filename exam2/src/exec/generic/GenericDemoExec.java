package exec.generic;

import data.generic.EmployeeInfo;
import data.generic.Person;
import data.generic.StudentInfo;

public class GenericDemoExec {
	
	public static void main(String[] args) {
		
		//Person<String> p1 = new Person<String>();
		//Person<StringBuilder> p2 = new Person<StringBuilder>();
		
//		Person<EmployeeInfo> p1 = new Person<EmployeeInfo>(new EmployeeInfo(1));
//		EmployeeInfo eil = p1.info;
//		System.out.println(eil.rank);
//		
//		Person<StudentInfo> p2 = new Person<StudentInfo>(new StudentInfo(2));
//		StudentInfo sil = p2.info;
//		System.out.println(sil.grade);
//		EmployeeInfo e = new EmployeeInfo(1);
//		Integer i = new Integer(10);
//		
//		Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);		
//		System.out.println(p1.info.rank);
//		System.out.println(p1.id.intValue());
		
//		p1.<EmployeeInfo>printInfo(e);
//		p1.printInfo(i);
		
		EmployeeInfo e = new EmployeeInfo(1);
		
		Person<EmployeeInfo> p1 = new Person<EmployeeInfo>(e);
		System.out.println(p1.info.getLevel());
		
			
	}

}
