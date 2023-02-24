package Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx {

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		
		// 파일을 읽기 위한 바이트 배열 선언
		byte _read[] = new byte[100];
		
		// 콘솔에서 키보드로 입력한 값을 저장할 바이트 배열 선언
		byte console[] = new byte[100];
		
		try {
			
			System.out.print("파일명 : ");

			System.in.read(console);
			
			String file = new String(console).trim();
			
			fis = new FileInputStream(file);
			
			fis.read(_read, 0, _read.length);
			
			System.out.println(new String(_read).trim());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e2) {
			e2.printStackTrace();
		} finally {
			try {
				
				if(fis != null) fis.close();
			
			} catch (IOException e3) {
				e3.printStackTrace();
			}
		}
		
	}

}
