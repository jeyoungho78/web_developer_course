package JavaFirst;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamExample04 {
	
	public static void main(String[] args) throws Exception{
		byte[] buf = {65, 66, 67, 68, 69};
		ByteArrayInputStream bais = null;
		
		try {
			
			bais = new ByteArrayInputStream(buf);
			
			System.out.println("Byte read " + bais.read());
			System.out.println("Byte read " + bais.read());
			System.out.println("Byte read " + bais.read());
			System.out.println("Byte read " + bais.read());
			System.out.println("Byte read " + bais.read());
			
			System.out.println("Reset() invocation");
			
			bais.reset();
			
			System.out.println("Byte read " + bais.read());
			System.out.println("Byte read " + bais.read());
			System.out.println("Byte read " + bais.read());
			System.out.println("Byte read " + bais.read());
			System.out.println("Byte read " + bais.read());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(bais != null)
				bais.close();
		}
		
	}
	

}
