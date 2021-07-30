package day15;

/*
 * Implicit and explicit conversion demo
 */
public class Demo6 {
	public static void main(String[] args) {
		// implicit casting
		int a = 10;
		long b = a; // automatically converts integer type into long type
		float c = b; // automatically converts long type into float type
		double d = c; // automatically converts float type into double type
	
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		// explicit casting
		double a1 = 123.45;
		//long b1 = a1; // throws error because explicit conversion cannot be done automatically by compiler
		long b1 = (long) a1; // converts double to into long type explicitly
		int c1 = (int) b1; // converts long to into int type explicitly
		
		System.out.println(a1);
		// following two ignore all values after decimal
		System.out.println(b1); 
		System.out.println(c1);
	}
}
