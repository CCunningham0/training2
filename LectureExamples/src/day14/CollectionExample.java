package day14;

import java.util.ArrayList;
import java.util.Collections;

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
		System.out.println("\nAdded element at index 0: " + colors.get(0));
		
		// Retrieve element at specified position
		int index = 0;
		System.out.println("\nRetrieved element at index " + index + ": " + colors.get(index));
		
		// Update element with given element
		String prevElement = colors.remove(0);
		colors.add(0, "Purple");
		System.out.println("\nUpdated element at index " + index + ": " + colors.get(index));
		System.out.println("Previous element at index " + index + " was: " + prevElement);
		
		// Remove third element in array list
		//System.out.println(colors);
		prevElement = colors.remove(2);
		System.out.println("\nRemoved third elment in array: " + prevElement);
		System.out.println("Element is now: " + colors.get(2));
		
		// Search for element in array list
		String givenElement = "Red";
		int count = 0;
		while (!colors.get(count).equals(givenElement)) {
			count++;
		}
		System.out.println("\nFound element " + colors.get(count) + " at index " + count + "\n");
		
		// Sort array list
		System.out.println("Sorting array list : " + colors);
		Collections.sort(colors);
		System.out.println("Sorted array list: " + colors + "\n");
		
		// Copy array list into another array list
		ArrayList<String> colorShades = new ArrayList<>();
		colorShades.add("Light");
		colorShades.add("Medium");
		colorShades.add("Dark");

		colors.addAll(0, colorShades);
		for (int i = 0; i < colorShades.size(); i++){
			System.out.println("Element at index " + i + " is now: " + colors.get(i));
		}
		
	}
}
