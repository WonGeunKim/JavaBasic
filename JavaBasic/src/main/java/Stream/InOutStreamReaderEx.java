package Stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InOutStreamReaderEx {
	
	// InputStreamReader 클래스는 문자 그대로 InputStream을 Reader로 바꿔주는 클래스
	
	public static String consoleInput(String input) throws IOException {
		
		System.out.println(input + " : ");
		
		// 바이트 입력 스트림을 InputStreamReader 클래스를 이용하여 문자 입력 스트림인 InputStreamReader 객체를 생성
		InputStreamReader isr = new InputStreamReader(System.in);
		
		// InputStreamReader 객체를 이용해서 BufferedReader 객체를 생성
		BufferedReader br = new BufferedReader(isr);
		
		// 한 줄을 읽을 수 있는 readLine() 메서드를 이용
		String message = br.readLine();
		
		return message;
	}
	

	public static void main(String[] args) throws IOException{

		String id = consoleInput("id");
		String password = consoleInput("password");
		
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		
		out.write("id : " + id + ", password : " + password);
		out.close();
	}

}
