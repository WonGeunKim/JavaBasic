package Stream;

import java.io.FileReader;

public class FileReaderEx {

	public static void main(String[] args) {
		
		FileReader fr = null;
		
		try {
			
			fr = new FileReader("c:\\Test\\fileReader.txt");
			
			int readChar;
			
			while((readChar = fr.read()) != -1) {
				System.out.println((char) readChar);
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(fr != null) fr.close();
				
			} catch (Exception e2) {

				e2.printStackTrace();
			}
			
		}
		
	}

}
