package Stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		FileOutputStream fos = null;
		
		try {
			
			File f = new File("c:\\Test");
			
			if(!f.exists()) f.mkdir();
			
			fos = new FileOutputStream("c:\\Test\\fileout.txt");
			
			String message = "Hello FileOutputStream!!";
			
			fos.write(message.getBytes());
			
		} catch (Exception e) {
		
			e.printStackTrace();
		} finally {
			
			try {
				
				if(fos != null) fos.close();
				
			} catch (Exception e2) {
			
				e2.printStackTrace();
			}
		}
		
	}

}
