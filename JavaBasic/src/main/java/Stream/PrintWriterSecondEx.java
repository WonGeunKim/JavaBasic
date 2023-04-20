package Stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterSecondEx {

	public static void main(String[] args) {
		
		PrintWriter pw = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			
			fos = new FileOutputStream("c:\\Test\\printWriterSecond.txt");
			bos = new BufferedOutputStream(fos);
			pw = new PrintWriter(bos, true);
			pw.println("안녕하세요!!");
			pw.println("또 만났네요.");
			pw.println(100.1);
			pw.println(new Boolean(true));
			
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				
				if(fos != null) fos.close();
				if(bos != null) bos.close();
				if(pw != null) pw.close();
				
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
