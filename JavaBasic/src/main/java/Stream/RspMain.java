package Stream;

import java.util.Random;
import java.util.Scanner;

public class RspMain {

	public static void main(String[] args) {
		
		RspInfo rinfo = new RspInfo();
		
		String id;
		
		int win = 0;
		int lose = 0;
		int draw = 0;
		
		System.out.print("아이디를 입력하세요 : ");
		
		Scanner scan = new Scanner(System.in);
		
		id = scan.nextLine();
		rinfo.setName(id.trim());
		
		try {
			
			ScoreLoader loader = new ScoreLoader(rinfo);
			
			win = loader.getInfo().getWin();
			lose = loader.getInfo().getLose();
			draw = loader.getInfo().getDraw();
			
			rinfo.setWin(win);
			rinfo.setDraw(draw);
			rinfo.setLose(lose);
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		}
		
		System.out.println(win + "승, " + lose + "패, " + draw + "무");
		
		while(true) {
			
			int random = new Random().nextInt(3);
			
			// 0 : 가위 , 1 : 바위 , 2 : 보
			System.out.print("가위(s) | 바위(r) | 보(p) ? : ");
			
			String user = scan.next();
			int usercnt = 0;
			
			if(user.equalsIgnoreCase("s")) {
				usercnt = 0;
			}else if(user.equalsIgnoreCase("r")) {
				usercnt = 1;
			}else if(user.equalsIgnoreCase("p")) {
				usercnt = 2;
			}
			
			// 경우의 수 비교
			if(usercnt - random == -2 || usercnt - random == -1) {
				System.out.println("이겼습니다."); // 이긴 경우
				rinfo.setWin(++win);
			}else if(usercnt - random == 0) {	// 비긴 경우
				System.out.println("비겼습니다.");
				rinfo.setDraw(++draw);
			}else {	// 진 경우
				System.out.println("졌습니다.");
				rinfo.setLose(++lose);
			}
			
			System.out.println(rinfo.getWin() + "승," + rinfo.getLose() + "패," + rinfo.getDraw() + "무");
			System.out.print("한판 더?? y | n : ");
			String select = scan.next();
			
			if(!select.equals("y")) {
				break;
			}
			
		}
		System.out.println("게임이 종료되었습니다.");
		
		// 파일쓰기
		try {
			
			ScoreWriter sw = new ScoreWriter(rinfo);
		} catch (Exception e) {

			e.printStackTrace();
		}
			
	}

}
