package day13;

public class Demo1 {
	// String example
	// -Using "new" keyword
	// -JVM will not check string pool for duplicate string, creates a new string object
	// 	and places it in string pool in heap
	char[] chr = {'h', 'i', 'j', 'k'};
	String str = new String(chr); // Converts character array to string
	
	String str3 =  new String("World"); // Creates string using "new" keyword
	
	// Second example with the same result
	// -Using string literal
	// -JVM will check for duplicate string and place reference in str2 if found (str and str2
	// 	will point to same string object in string pool in heap memory)
	String str2 = "hijk";
}

class Demo2 {
	public static void main(String[] args) {
		
		String str1 = "Hello";
		
		// Uses concat() method to append string to end of str1 (creates new string
		// with "HelloWorld" in instance
		str1.concat("World"); 
		
		System.out.println(str1); // Will only print "Hello" because strings are immutable
	
		String str2 = str1.concat("World"); // New string str2 will point to new string object with "HelloWorld"
		System.out.println(str2);
	}
}