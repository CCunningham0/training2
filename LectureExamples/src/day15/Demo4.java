package day15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Thread pool demo
 */
class WorkerThread implements Runnable {
	private String message;
	
	public WorkerThread(String msg) {
		this.message = msg;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "Start message: " + message);
		processMessage();
		System.out.println(Thread.currentThread().getName() + "End message: " + message);
	}
	
	private void processMessage() {
		try	{
			Thread.sleep(2000);	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	}
	}
}


public class Demo4 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread(" " + i);
			executorService.execute(worker); // calls execute method of executor service
		}
		
		executorService.shutdown();
		while (!executorService.isTerminated()) {
			
		}
		System.out.println("Finished all threads");
	}
}
