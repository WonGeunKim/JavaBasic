package Stream;

import java.util.Scanner;

public class ScannerRegEx {

	public static void main(String[] args) {

		String str = "1 and 2 and animal and lion and tiger";
		
		Scanner scan = new Scanner(str);
		
		// 정규 표현식에서 빈 공백은 '\s'
		// *의 의미는 0개 이상을 의미
		// '\\s*'에서 '\'를 한 개 더 사용한 이유는 '\'는 문자열에서 인식하지 못하는 이스케이트 문자이기 때문에 반드시 이스케이트 문자 앞에 '\'를 사용해야 한다
		// 따라서 '\\s*' 의 의미는 0개 이상의 빈 공백을 의미
		// '\\s*and\\s*' 는 "and 앞뒤에 있는 0개 이상의 빈 공백"을 의미
		scan = scan.useDelimiter("\\s*and\\s*");
		
		int firstToken = scan.nextInt();
		int secondToken = scan.nextInt();
		
		String thirdToken = scan.next();
		String fourthToken = scan.next();
		String fifthToken = scan.next();
		
		System.out.printf("%d, %d, %s, %s, %s", firstToken, secondToken, thirdToken, fourthToken, fifthToken);
		
		scan.close();
		
	}

}
