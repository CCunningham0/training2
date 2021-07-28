package day13;

import java.util.Arrays;

public class Demo5 {
	public static void main(String[] args) {
		String message = "Welcome to java";
		// From index 0 to 7
		System.out.println(message.substring(0, 7)); // Prints "Welcome"
		
		// From index 8 to end
		System.out.println(message.substring(8)); // Prints "to java"
		
		/*
		 * split() method
		 */
		String message2 = "Hello, welcome to java";
		
		String[] result = message2.split("\\,"); // Splits string into two part/index array separated by comma
		System.out.println(Arrays.toString(result)); // Prints [Hello, welcome to java] 
		
	}
}
