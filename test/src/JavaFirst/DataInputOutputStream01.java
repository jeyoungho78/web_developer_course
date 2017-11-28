package JavaFirst;

import java.io.*;

public class DataInputOutputStream01 {
	public static void main(String[] args) {
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("c:/temp/datastream.txt"));
			dos.writeChar('c');
			dos.writeInt(897);
			dos.writeDouble(234.6);
			dos.writeByte(34);
			dos.writeBoolean(true);
			dos.writeUTF("안녕하세요");
			dos.writeUTF("환영합니다");
			dos.flush();
			dos.close();
			
			System.out.println("데이터 파일 입출력 : " );
			System.out.println("--------------------------------------" );
			DataInputStream dis = new DataInputStream(new FileInputStream("c:/temp/datastream.txt"));
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readByte());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readUTF());
			System.out.println(dis.readUTF());
			dis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
