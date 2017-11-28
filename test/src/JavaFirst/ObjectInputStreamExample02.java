package JavaFirst;

import java.io.*;
import JavaCall.User;

public class ObjectInputStreamExample02 {
	
	public static void main(String[] args) {
		try {
			User user1 = new User("gildong", "hong", "email1@gmail.com");
			User user2 = new User("hyun", "ryu", "email2@gmail.com");
			
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("c:/temp/user.txt"));
			output.writeObject(user1);
			output.writeObject(user2);
			output.flush();
			output.close();
			
			System.out.println("객체저장완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
