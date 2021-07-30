package day15;

/*
 * Thread scheduler demo
 */
class ThreadSleepDemo extends Thread {
	@Override
	public void run() {
		/*
		 * t1 is executed (prints 0), then t2 is executed and 0 is printed again
		 */
		for (int i = 0; i < 10; i++) {
			// Makes thread sleep
			try {
				Thread.sleep(2000); // checked exception
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(i);
		}
	}
}

public class Demo2 {
	public static void main(String[] args) {
		ThreadSleepDemo t1 = new ThreadSleepDemo();
		ThreadSleepDemo t2 = new ThreadSleepDemo();
		t1.start();
		t2.start();
	}
}
