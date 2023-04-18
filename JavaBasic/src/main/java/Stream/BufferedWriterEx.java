package Stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterEx {

	// BufferedWriter 클래스 : 문자 기반 스트림의 효율적 버퍼링을 가능하게 한다
	// BufferedWriter 클래스의 생성자느 어떤 예외처리를 하지 않아도 된다
	
	public static void main(String[] args) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			
			fw = new FileWriter("c:\\Test\\bufferWriter.txt");
			bw = new BufferedWriter(fw);
			bw.write("BufferedWriter 테스트입니다.");
			
			// newLine() 메서드는 행을 종료하라는 표시, 행종결 문자로 사용
			bw.newLine();
			
			
			bw.write("안녕하세요" + 
					System.getProperty("line.separator"));	// 시스템의 행종결 문자를 반환
			
			// flush() 메서드는 버퍼에 문자가 다 차지 않더라도 버퍼의 내용을 모두 출력하는 메서드
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(fw != null) fw.close();
				
				// bw.close() 메서드는 bw를 플러시하고, bw를 닫는 두 가지 기능을 해준다
				// => flush()를 주석처리해도 문자를 출력(쓰기)하는 데는 문제x
				if(bw != null) bw.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
