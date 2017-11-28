package JavaFirst;

import java.io.*;

import JavaCall.User;

public class ObjectInputStreamExample02Exec {
	
	public static void main(String[] args) {
		
		ObjectInputStream input  = null;
		try {
			input = new ObjectInputStream(new FileInputStream("c:/temp/user.txt"));
			
			User user = null;
			
			//System.out.println("input.available() : " + input.available());
			
			while(true) {
				user = (User)input.readObject();
				System.out.println(user.getFirstName());
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("전체 출력완료");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
