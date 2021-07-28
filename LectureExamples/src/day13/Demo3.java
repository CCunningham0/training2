package day13;

public class Demo3 {
	public static void main(String[] args) {
		/*
		 * equals() compares content/value
		 * boolean equals(other object) - compare string to other object
		 * boolean equalsIgnoreCase(other object) - compare string to other object while ignoring case
		 */
		String s1 = "mark";
		String s2 = "mark";
		String s3 = new String("mark");
		String s4 = "paul";
		
		System.out.println(s1.equals(s2)); // true
		System.out.println(s1.equals(s3)); // true
		System.out.println(s1.equals(s4)); // false
		
		/*
		 * == operator compares memory location (reference)
		 */
		System.out.println(s1 == s2); // true - both refer to same instance (pooled string literals)
		System.out.println(s1 == s3); // false - refer to different instances
		
		/*
		 * compareTo() compares value but does NOT return boolean value
		 * Returns an integer based on if first string is less or greater than second string
		 * -Characters given numerical value to determine less than/greater than
		 */
		
		System.out.println(s1.compareTo(s2)); // return positive (0) - because they are equal
		System.out.println(s1.compareTo(s4)); // return negative (-3) - because s1 is less than s3
	}
}
