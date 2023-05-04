package Stream;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx {

	public static void main(String[] args) {
		
		RandomAccessFile ra = null;
		
		try {
			
			ra = new RandomAccessFile("c:\\Test\\random.txt", "rw");
			
			String receive = "hello";
			ra.seek(ra.length());
			ra.write(receive.getBytes());
			byte[] buf = new byte[(int) ra.length()];
			ra.seek(0);
			ra.read(buf);
			System.out.print("처음 읽은 내용 : ");
			System.out.println(new String(buf));
			ra.seek(0);
			ra.read(buf);
			System.out.print("다시 읽은 내용 : ");
			System.out.println(new String(buf));
			
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			
			try {
				
				if(ra != null) ra.close();
				
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
