package day14;

import java.util.Hashtable;
import java.util.Map;

public class Demo17 {
	public static void main(String[] args) {
		/*
		 * Map HashTable example
		 */
		Hashtable<Integer, String> hashtable = new Hashtable<>();
		hashtable.put(1, "Mark");
		hashtable.put(2,"Paul");
		
		for (Map.Entry entry: hashtable.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
