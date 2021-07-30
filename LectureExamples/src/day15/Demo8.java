package day15;

import java.util.Scanner;

/*
 * Scanner class demo
 */
public class Demo8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter firstname and then lastname");
		
		String firstName = scanner.nextLine();
		String lastName = scanner.nextLine();
		
		System.out.println("Full name is: " + firstName + " " + lastName);
	}
}
