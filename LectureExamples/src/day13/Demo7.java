package day13;

public class Demo7 {
	public static void main(String[] args) {
		/*
		 * StringBuilder
		 * Similar to StringBuffer but non-synchronized
		 */
		StringBuilder sb = new StringBuilder("Hello");
		sb.append(" World");
		System.out.println(sb); // Prints "Hello World"
		
		/*
		 * StringBuffer vs. StringBuilder
		 */
		// StringBuffer
		long startTime = System.currentTimeMillis();
		StringBuffer stringBuff = new StringBuffer("Hello");
		for (int i = 0; i < 10000; i++) {
			stringBuff.append(" World");
		}
		System.out.println("Time taken by StringBuffer: " + (System.currentTimeMillis() - startTime));
	
		// StringBuilder
		startTime = System.currentTimeMillis();
		StringBuilder stringBuild = new StringBuilder("Hello");
		for (int i = 0; i < 10000; i++) {
			stringBuild.append(" World");
		}
		System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime));
	}
}
