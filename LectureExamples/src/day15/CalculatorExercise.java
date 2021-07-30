package day15;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Calculator exercise
 */
public class CalculatorExercise {
	/* 
	 * TO DO:
	 * 1. get user first number
	 * 2. get user second number
	 * 3. select option:
	 * 	a. add
	 *  b. subtract
	 *  c. multiply
	 *  d. divide
	 * 4. print result
	 * 
	 * Then do EMI calculator
	 * 1. enter:
	 *  - loan amount
	 *  - ROI
	 *  - Tenure
	 * 2. print result
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean hasQuit = false;
		int firstNum = 0;
		int secondNum = 0;
		
		System.out.println("Calculator is has started!");
		try {
			System.out.println("Please enter number:");
			firstNum = scanner.nextInt();
			
			System.out.println("Please enter a second number:");
			secondNum = scanner.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("Not a valid number");
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		System.out.println("Which operation would you like to perform?");
		System.out.println("Please enter either 'add', 'subtract', 'multiply', or 'divide'.");
		String operation = scanner.next();
		
		switch (operation){
			case "add": System.out.println("The sum of " + firstNum + " and " + secondNum + " is: "
					+ (firstNum + secondNum));
				break;
		
			case "subtract": System.out.println(secondNum + " subtracted from " + firstNum + " is: "
					+ (firstNum - secondNum));
				break;
				
			case "multiply": System.out.println(firstNum + " multiplied by " + secondNum + " is: "
						+ (firstNum * secondNum));
				break;
			
			case "divide": System.out.println(firstNum + " divided by " + secondNum + " is: "
					+ (firstNum / secondNum));
			
			default: System.out.println("Not a valid operation");
				break;
		}
			
	
	}
}
