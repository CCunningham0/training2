package day15;

// Class acts as thread because it extends Thread class
class MultiThreadDemo extends Thread {
	@Override
	public void run() {
		//super.run();
		System.out.println("thread is running...");
	}
}

// Class implements Runnable interface (mandates overriding run() method)
class MultiThreadDemo2 implements Runnable {
	@Override
	public void run() {
		System.out.println("thread is running...");
	}
}

public class Demo1 {
	public static void main(String[] args) {
		/*
		 * Creating thread by extending Thread class is simpler but can not extend any other class
		 */
		MultiThreadDemo threadDemo = new MultiThreadDemo();
		// MultiThreadDemo: must start thread with start()
		threadDemo.start(); // start() method defined in Thread class
		
		/*
		 * Creating thread by implementing Runnable is better if developer may need to extend another class
		 */
		// MultiThreadDemo2: uses start through Thread object and passing threadDemo
		Thread t1 = new Thread(threadDemo);
		t1.start();
	}
}
