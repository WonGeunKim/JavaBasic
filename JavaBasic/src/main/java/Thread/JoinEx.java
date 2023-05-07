package Thread;

import java.io.IOException;

class MyRunnableTwo implements Runnable {

	@Override
	public void run() {
		
		System.out.println("run");
		first();
	}

	public void first() {
		System.out.println("first");
		second();
	}

	public void second() {
		System.out.println("second");
	}
	
}


public class JoinEx {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName() + " start");
		
		Runnable r = new MyRunnableTwo();
		Thread myThread = new Thread(r);
		myThread.start();
		
		try {
			
			myThread.join();
			// join() 메서드는 InterruptedException 예외를 발생하기 때문에 반드시 예외처리를 해야 한다.
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " end");
		
	}

}
