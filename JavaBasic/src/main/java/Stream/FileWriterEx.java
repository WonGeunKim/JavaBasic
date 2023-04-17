package Stream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {

	// FileWriter 클래스는 문자 파일에 출력(쓰기)할 때 사용하는 클래스
	// FileWriter 클래스의 생성자는 파일의 경로, File 객체를 이용하여 만들 수 있다
	
	public static void main(String[] args) {
		
		FileWriter fw = null;
				
		try {
			
			// FileWriter 클래스의 객체가 생성되면 파일이 생성된다
			fw = new FileWriter("c:\\Test\\fileWriter.txt");
			
			String message = "안녕하세요 FileWriter 테스트";
			
			// 문자열을 쓸 수 있는 메서드 제공
			fw.write(message);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if(fw != null) fw.close();
				
			} catch (IOException e2) {
			
				e2.printStackTrace();
			}
		}
		
		
	}

}
