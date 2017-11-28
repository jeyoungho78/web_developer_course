package exec.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import data.collection.Data;

public class Exec {

	public static void main(String[] args) {
		
		Data dt1 = new Data("È«±æµ¿", 10, 20);
		Data dt2 = new Data("Çã±Õ", 30, 40);
		Data dt3 = new Data("ÀÌ¼ø½Å", 50, 60);
		
		//List<Data> list = new ArrayList<>();
		List<Data> list = new Vector<Data>();
		list.add(dt1);
		list.add(dt2);
		list.add(dt3);
		
		Data dt4 = new Data("ÀÓ²©Á¤", 70, 80);
		list.add(1, dt4);
		
		Data dt = null;
		for(int i =0; i < list.size(); i ++) {
			dt = (Data)list.get(i);
			System.out.println(dt.name + " " + dt.kor + " " + dt.eng);
		}
		
	}//main
}//class
