package Stream;

import java.io.IOException;

public class InputStreamEx {

	public static void main(String[] args) throws IOException{
		
		System.out.println("입력하세요..");
		
		int _byte;
		 
		// System.in : 표준 입력 스트림을 의미
		// => 키보드와 연결되어 있는 InputStream 객체
		// read() 메서드 : 입력 스트림이 오기 전까지 대기하는 블로킹 메서드
		while(((_byte = System.in.read()) != 1)) {
			
			if(_byte == '\r' || _byte == '\n') continue;
			
			if(_byte == 'q' || _byte == 'Q') break;
			
			char c = (char) _byte;
			
			System.out.printf("%s(%d)", c, _byte);
		}
		
		
	}

}
