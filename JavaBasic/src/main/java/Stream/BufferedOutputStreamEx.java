package Stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamEx {

	// BufferedOutputStream을 사용하면, 출력문이 있더라도 출력장치로 물리적 데이터 전송이 실제로 일어나지는 않게 된다
	// => 각 출력 연산은 여러 출력 연산의 데이터를 수용할 만큼 넓은 버퍼라는 기억장치 내의 어느 범위로 보내진다
	// 버퍼가 채워질 때마다 한번에 대량으로 출력장치로의 실제 전송이 수행된다
	
	public static void main(String[] args) {
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			
			fos = new FileOutputStream("c:\\Test\\BufferOut.txt");
			bos = new BufferedOutputStream(fos);
			
			String str = "BufferedOutputStream Test 입니다.";
			
			bos.write(str.getBytes());
			bos.flush();
			
		} catch (Exception e) {
		
			e.printStackTrace();
		} finally {
			
			try {
				
				if(fos != null) fos.close();
				if(bos != null) bos.close();
				
			} catch (Exception e2) {
			
				e2.printStackTrace();
			}
		}
		
	}

}
