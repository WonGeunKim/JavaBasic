package Stream;

import java.io.File;
import java.io.IOException;

public class FileEx {

	public static void main(String[] args) throws IOException{
		
		// escape 문자를 String으로 사용하려면 '\'를 붙여줘야 한다
		// but
		// System.getProperty("file.separator") 를 사용하는 것이 좋다
		// => 운영체제별로 디렉토리를 구분하는 문자가 다르기 때문
		String filePath = "c:\\";
		
		File f1 = new File(filePath);
		
		// C 드라이브에 있는 모든 파일과 디렉토리를 String 배열로 반환
		String list[] = f1.list();
		
		
		for(int i = 0; i < list.length; i++) {
			
			// 파일과 디렉토리를 다시 File 객체로 생성한 후 디렉토리인지 파일인지 구분
			File f2 = new File(filePath, list[i]);
			
			if(f2.isDirectory()) {
				System.out.printf("%s : 디렉토리 %n", list[i]);
			}else {
				
				// %d 의 의미는 두 번 째 인자를 출력할 때 3자리마다 콤마를 찍는 것
				System.out.printf("%s : 파일(%,dbyte)%n", list[i], f2.length());
			}
		}
		
		File f3 = new File("c:\\test.txt");
		
		System.out.println(f3.createNewFile());
		System.out.println(f3.getAbsolutePath());
		System.out.println(f3.getCanonicalPath());
		System.out.println(f3.getPath());
		System.out.println(f3.getName());
		System.out.println(f3.getParent());
		
		File f4 = new File("c:\\test.txt");
		File f5 = new File("c:\\test1.txt");
		System.out.println(f4.renameTo(f5));
		
	}

}
