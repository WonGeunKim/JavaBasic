package Stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterFirstEx {

	// PrintWriter 클래스는 다른 스트림과 다르게 바이트 출력 스트림(OutputStream)과 문자 출력(Writer) 스트림을
	// 모두 매개변수로 받을 수 있는 생성자를 제공한다는 점
	// 그리고 자동 플러시 기능이 있다
	
	public static void main(String[] args) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			
			fw = new FileWriter("c:\\Test\\printWriterFirst.txt");
			
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true);	// true의 의미는 자동 플러시 기능
			pw.println("안녕하세여");
			pw.println("반갑습니다.");
			pw.println(100);
			pw.println(new Integer("1000"));
			
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			
				try {
					
					if(fw != null) fw.close();
					if(bw != null) bw.close();
					if(pw != null) pw.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			
		}
		
	}

}
