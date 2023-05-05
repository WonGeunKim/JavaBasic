package Thread;

public class SingleRunnableEx implements Runnable {

	private int temp[];
	
	public SingleRunnableEx() {
		
		temp = new int[10];
		for(int start = 0; start < 10; start++) {
			temp[start] = start;
		}
	}
	
	@Override
	public void run() {

		for(int start : temp) {
			
			try {
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			
			// 현재 수행중인 스레드 객체를 얻어 오기 위해 Thread.currentThread() 메서드를 사용
			// 이 메서드는 static 메서드이기 때문에 클래스 이름을 이용해서 호출
			System.out.printf("스레드 이름 : %s ," , Thread.currentThread().getName());
			
			System.out.printf("temp value : %d %n" , start);
		}
		
	}
	
	public static void main(String[] args) {
		
		// Runnable 인터페이스를 사용한 경우 Thread(Runnable r, String name) 생성자를 이용해야 한다
		
		SingleRunnableEx srt = new SingleRunnableEx();
		
		Thread t = new Thread(srt, "첫번째");
		t.start();
		
	}

}
