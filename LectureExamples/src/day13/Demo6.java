package day13;

public class Demo6 {
	public static void main(String[] args) {
		/*
		 * StringBuffer
		 */
		// append()
		StringBuffer sb = new StringBuffer("Hello");
		sb.append(" World");
		System.out.println(sb); // Prints "Hello World" because StringBuffer sb is mutuable (changeable)
		
		// insert()
		StringBuffer sa = new StringBuffer("Hello");
		sa.insert(0, "World "); // Inserts specified string at specified index ("World" starting at index 0)
		System.out.println(sa); // Prints "World Hello"
	}
}
