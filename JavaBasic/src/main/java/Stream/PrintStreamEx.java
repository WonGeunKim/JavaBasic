package Stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamEx {

	public static void main(String[] args) {
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		PrintStream ps = null;
		
		try {
			
			fos = new FileOutputStream("c:\\Test\\printStream.txt");
			bos = new BufferedOutputStream(fos);
			ps = new PrintStream(bos, true);
			
			ps.println("성영한");
			ps.println(1234);
			ps.println(true);
			ps.println('a');
			
		} catch (Exception e) {
		
			e.printStackTrace();
		} finally {
			
			try {
				if(fos != null) fos.close();
				if(bos != null) bos.close();
				if(ps != null) ps.close();
				
			} catch (Exception e2) {
			
				e2.printStackTrace();
			}
		}
	}
}
