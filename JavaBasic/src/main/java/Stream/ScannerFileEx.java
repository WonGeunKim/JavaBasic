package Stream;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerFileEx {

	public static void main(String[] args) {
		
		Scanner scan = null;
		
		try {
			
			scan = new Scanner(new File("c:\\Test\\scan.txt"));
			
			while(scan.hasNextDouble()) {
				
				// nextDouble : 다음 토큰을 double값으로 반환하는 메서드
				System.out.printf("스캔 double : %, .2f %n", scan.nextDouble());
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if(scan != null) scan.close();
		}
		
		
		
	}

}
