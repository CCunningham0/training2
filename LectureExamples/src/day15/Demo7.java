package day15;

/*
 * Boxing/Autoboxing and unboxing demo
 */
public class Demo7 {
	public static void main(String[] args) {
		// converting integer to int
		Integer a = new Integer(10); // strikeout line -> deprecated, may be removed in future
		int b = a.intValue();
		int c = a;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c + "\n");
		
		// try to convert all primitives into its wrapper class type
		byte aa = 10;
		short bb = 20;
		int cc = 30;
		long dd = 40;
		float ee = 12.3f;
		double ff = 12.24;
		char gg = 'a';
		boolean hh = true;
		
		// autoboxing: converting primitives into objects
		Byte byteObj = aa;
		Short shortObj = bb;
		Integer integerObj = cc;
		// etc.
		
		// unboxing: convert object into primitives
		byte byteValue = byteObj;
		short shortValue = shortObj;
		int intValue = integerObj;
		
		
	}
}
