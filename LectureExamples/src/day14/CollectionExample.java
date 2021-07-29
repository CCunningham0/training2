package day14;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.colorchooser.ColorSelectionModel;

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
		
		// Shuffle elements in array list
		System.out.println("\nShuffling array list : " + colors);
		Collections.sort(colors);
		System.out.println("Shuffled array list: " + colors + "\n");
		
		// Reverse elements in array list
		System.out.println("Reversing array list : " + colors);
		Collections.reverse(colors);
		System.out.println("Reversed array list: " + colors + "\n");
		
		// Extract portion of array list
		ArrayList<String> temp = new ArrayList<>();
		int startIndex = 1;
		int endIndex = 2;
		
		// add elements to temporary array list
		while (startIndex <= endIndex) {
			temp.add(colors.get(startIndex));
			startIndex++;
		}
		
		// iterate through array lists and remove any matching elements
		// to temporary array (avoids dynamic array list sizing)
		for (int j = 0; j < temp.size(); j++) {
			for (int i = 0; i < colors.size(); i++) {	
				if (colors.get(i).equals(temp.get(j))) {
					colors.remove(i);
					i = 0; // set back to beginning of array due to array resize after remove	
				}
			}
		}

		  
		System.out.println("Extracted elements: " + temp);
		System.out.println("New array list: " + colors);
		
		// Swap to elements in array list
		String firstElement;
		String lastElement;
		System.out.println("\nSwapping first and last elements of: " + colors);
		
		firstElement = colors.get(0);
		lastElement = colors.get(colors.size() - 1);
		
		// done after colors.get because array list is dynamic and indexes change after each remove()
		colors.remove(0);
		colors.remove(colors.size() - 1); // remove element at the last index
		
		colors.add(0, lastElement);		
		colors.add(colors.size(), firstElement); // add element AFTER element in last index
		System.out.println("Swapped array list: " + colors);
	}
}
