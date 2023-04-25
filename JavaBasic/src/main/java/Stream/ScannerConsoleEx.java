package Stream;

import java.util.Scanner;

public class ScannerConsoleEx {

	// 콘솔에 숫자를 입력받아 Scanner(InputStream source) 생성자를 이용
	
	public static void main(String[] args) {

		System.out.print("입력 : ");
		
		Scanner scan = new Scanner(System.in);
		
		int number = scan.nextInt();
		
		System.out.printf("스캔 : %d", number);
		
		scan.close();
		
	}

}
