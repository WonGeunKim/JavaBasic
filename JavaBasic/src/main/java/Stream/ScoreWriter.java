package Stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ScoreWriter {

	public ScoreWriter(RspInfo info) {
		
		String path = "c:/RspScore/" + info.getName().trim() + "/UserInfo.sav";
		
		File dir = new File("c:/RspScore");
		
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		File dir2 = new File(dir, info.getName().trim());
		
		if(!dir2.exists()) {
			dir2.mkdir();	// 유저가 입력한 아이디로 폴더를 생성
		}
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(info);
			
			if(oos != null) {
				oos.close();
			}
			
			System.out.println("기록저장");
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("기록저장 실패");
		
		}
		
	}
	
	
	
}
