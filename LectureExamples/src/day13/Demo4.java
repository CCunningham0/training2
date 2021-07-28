package day13;

public class Demo4 {
	public static void main(String[] args) {
		/*
		 * Concatenation using + operator
		 */
		String s1 = "Hello" + " World";
		System.out.println(s1); // Prints "Hello World"
		
		// Above code does the line below implicitly
		String s2 = (new StringBuilder()).append("Hello").append(" World").toString();
		
		String str2 = 10 + 20 + 30 + "Sum" + 40 + 50;
		 
		// Prints 60Sum4050 - because before string is computed (added) but everything after
		// the string ("Sum") is concatenated
		System.out.println(str2);			
		
		
		String sa1 = "hello";
		String sa2 = "world";
		String sa3 = sa1.concat(sa2);
		System.out.println(sa3); // Prints "helloworld"
	}
}
