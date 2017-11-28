package exec.io;

import java.util.Scanner;

public class IOConsole {

	public static void main(String[] args) throws Exception {
		
//		InputStream in = System.in;
		
//		int a = in.read();
//		int b = in.read();
//		int c = in.read();
//		
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
		
//		byte[] a = new byte[3];
//		in.read(a);
//		
//		for(byte i : a) {
//			System.out.println(i);
//		}
//		InputStreamReader reader = new InputStreamReader(in);
//		char[] a = new char[3];
//		reader.read(a);
//		
//		System.out.println(a);

//		InputStreamReader reader = new InputStreamReader(in);
//		BufferedReader br = new BufferedReader(reader);
//		
//		String a = br.readLine();
//		System.out.println(a);

		Scanner sc = new Scanner(System.in);
		System.out.println(sc.next());
		
	}
	
}
