package Stream;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScannerReadableEx {

	public static void main(String[] args) {
		
		Scanner scan = null;
		
		FileReader fr = null;
		
		try {
			
			fr = new FileReader("c:\\Test\\scan.txt");
			scan = new Scanner(fr);
			while(scan.hasNextDouble()) {
				System.out.printf("스캔 double : %, 2f %n", scan.nextDouble());
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				if(fr != null) fr.close();
			} catch (IOException e2) {

				e2.printStackTrace();
			}
			if(scan != null) scan.close();
		}
		
		
	}

}
