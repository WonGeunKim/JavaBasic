package Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ScoreLoader {

	private RspInfo info;

	public RspInfo getInfo() {
		return info;
	}
	
	public ScoreLoader(RspInfo info) {
		this.info = info;
		
		String path = "c:/RspScore/"
				+ info.getName().trim() + "/UserInfo.sav";
		
		File f1 = new File(path);

		// 파일이 실제 존재할 때만 수행
		if(f1.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
				this.info = (RspInfo)ois.readObject();
				
				if(ois != null) {
					ois.close();
				}
				
				System.out.println("로드성공");
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("로드실패");
			
			}
		}else {
			System.out.println("새로운 아이디 생성");
		}
		
	}
	
}
