package Stream;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderEx {

	// Buffered Reader 클래스(추상 클래스 Reader의 하위 클래스) : 문자 입력 스트림의 효율적 버퍼링을 가능하게 한다
	
	// BufferedReader(Reader in) : 매개변수인 Reader 객체로 BufferedReader 객체를 생성
	
	// BufferedReader(Reader in, int size) : 매개변수인 Reader 객체로 BufferedReader 객체를 생성하고
	// size는 버퍼의 크기를 정하는 부분인데, 만약 정하지 않으면 8192문자로 정할 수 있는 버퍼가 생성된다
	
	// BufferedReader 클래스의 객체를 생성할 때 매개변수로 Reader 클래스의 자식 클래스를 지정
	// 일반적으로 FileReader, InputStreamReader 클래스를 이용하여 생성
	
	// BufferedReader 클래스의 메서드 중에 readLine() 메서드 : 한줄의 끝을 '\n', '\r' 중의 하나가 올 경우 
	// 또는 '\r\n'이 오는 경우를 한 줄의 끝으로 간주
	
	
	public static void main(String[] args) {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {

			fr = new FileReader("c:\\Test\\bufferReader.txt");
			br = new BufferedReader(fr);
			
			String msg;
			
			while((msg = br.readLine()) != null) {
				System.out.println(msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if(fr != null) fr.close();
				if(br != null) br.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
