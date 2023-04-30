package Stream;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ScannerURLConnectionEx {

	public static void main(String[] args) {
		
		URLConnection urlCon = null;
		
		Scanner scan = null;
		
		try {
			
			// URLConnection 객체를 생성
			urlCon = new URL("http://www.oracle.com").openConnection();
			
			// urlCon.getInputStream()의 리턴 타입은 InputStream이기 때문에 Scanner(InputStream source) 생성자를 이용해서 Scanner 객체를 생성
			scan = new Scanner(urlCon.getInputStream());
			
			// 구분 패턴을 지정
			// "\\Z"는 문서를 끝까지 읽으라느 정규 표현식
			scan.useDelimiter("\\Z");
			
			String text = scan.next();
			
			System.out.println(text);
			
		} catch (IOException e) {
		
			e.printStackTrace();
		} finally {
			
			if(scan != null) scan.close();
		}
		
		
	}

}
