package Thread;

public class SingleThreadEx extends Thread{

	private int [] temp;
	
	public SingleThreadEx(String threadname) {
		
		// super(threadname)을 호출하면 Thread 클래스의 Thread(String name)을 호출하기 때문에
		// Thread의 이름을 정할 때 사용
		super(threadname);
		
		temp = new int[10];
		for(int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
		
	}
	
	public void run() {
		
		for(int start : temp) {
			
			try {
				
				// sleep(1000) 메서드는 스레드를 일시적으로 sleep하는 메서드
				// 이 메서드는 Thread 클래스에서 제공하는 메서드
				sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// 현재 수행중인 스레드 객체를 알려면 Thread 클래스의 currentThread() 메서드를 사용
			System.out.printf("스레드 이름 : %s , " , currentThread().getName());
			
			System.out.printf("temp value : %d %n" , start);
		}
		
	}
	
	public static void main(String[] args) {
		
		SingleThreadEx st = new SingleThreadEx("첫번째");
		st.start();
		
	}

}
