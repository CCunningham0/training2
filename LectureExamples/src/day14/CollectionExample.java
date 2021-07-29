package day14;

import java.util.ArrayList;

public class CollectionExample {
	public static void main(String[] args) {
		/*
		 * ArrayList
		 */
		ArrayList<String> colors = new ArrayList<>();
		colors.add("Green");
		colors.add("Blue");
		colors.add("Red");
		
		// Print out collection
		System.out.println("Array list: " + colors + "\n");
	
		// Iterate through ArrayList
		for (int i = 0; i < colors.size(); i++){
			System.out.println("Element at index " + i + ": " + colors.get(i));
		}
		
		// Insert element at first position
		colors.add(0, "Yellow");
		
		// Retrieve element at specified position
		int index = 0;
		System.out.println("\nRetrieved element at index " + index + ": " + colors.get(index));
		
		// Update element with given element
		//colors.remove(0);
		String prevElement = colors.get(index);
		colors.add(0, "Purple");
		System.out.println("\nElement at index " + index + " set to: " + colors.get(index));
		System.out.println("Previous element at index " + index + " was: " + prevElement);
	}
}
