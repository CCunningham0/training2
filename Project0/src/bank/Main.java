package bank;

import java.util.Scanner;

/*
 * Main class for Bank application - Project0
 */
public class Main {
	static User user = new User(null, null);
	
	
	public static void main(String[] args) {
		
		/*
		 * TODO:
		 * 	1. get input via scanner object
		 * 	2. create custom stored procedure to perform some functionality (i.e. store account info?)
		 * 	3. access database using JDBC and data access objects
		 * 	4. use log4j to log events in a file
		 * 	5. write at least 1 JUnit test
		 * 
		 */
		
		/*
		 * ## User Stories
		 * As a user, I can login. 
		 * As a customer, I can apply for a new bank account with a starting balance. 
		 * As a customer, I can view the balance of a specific account. 
		 * As a customer, I can make a withdrawal or deposit to a specific account. 
		 * As the system, I reject invalid transactions. 
	 	 * Ex: * A withdrawal that would result in a negative balance.
		 * A deposit or withdrawal of negative money. 
		 * As an employee, I can approve or reject an account. 
		 * As an employee, I can view a customer's bank accounts. 
		 * As a user, I can register for a customer account. 
		 * As a customer, I can post a money transfer to another account. 
		 * As a customer, I can accept a money transfer from another account. 
		 * A an employee, I can view a log of all transactions.
		 */
		
		
		// Start of application
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the banking application!");
		//FIXME: add functionality for new user to create account?
		
		System.out.println("Please enter your username.");
		String username = scanner.nextLine().toLowerCase();

		System.out.println("Please enter your password.");
		String password = scanner.nextLine().toLowerCase();
		
		if (!validateLogin(username, password)) {
			System.out.println("Invalid login information");
			scanner.close();
			return;
		}
		
		System.out.println("Hello " + user.username + "!");
		
		// if user is customer
		if (user.userType.equals("customer")) {
			System.out.println("Please enter a number, the options are as follows:\n"
					+ "1. Apply for a new bank account.\n"
					+ "2. View the balance of an account.\n"
					+ "3. Withdraw from or deposit into an account.\n"
					+ "4. Transfer money to an account.\n"
					+ "5. Accept any pending transfers from another account.");
			parseInput(scanner.nextInt(), user);
		}
		
		// if user is employee
		if (user.userType.equals("employee")) {
			System.out.println("Please enter an action, the options are as follows:\n"
					+ "1. Approve or reject a pending account.\n"
					+ "2. View customer's bank accounts.\n"
					+ "3. Create a new account.\n"
					+ "4. View transaction log for account(s).");
		}
		
		
		scanner.close();
		
		//parseInput(getInput("login"), user);
		
	}
	
	/*
	 * Get input from user with scanner object
	 */
	public static String getInput(String action) {
		Scanner scanner = new Scanner(System.in);
		String input = null;
		
		
		scanner.close();
		return input;
	}
	
	/*
	 * Validate and parse user input and return result
	 */
	public static <T> String parseInput(T input, User user) {
		if (user.username.equals("customer")) {
			switch((int)input) {
				case 1: // call method for action
				case 2: // call method for action
				case 3: // call method for action
				case 4: // call method for action
				case 5: // call method for action
				default: // input not a number between 1 and 5
			}
		} else {
			switch((int)input) {
				case 1: // call method for action
				case 2: // call method for action
				case 3: // call method for action
				case 4: // call method for action
			}
		}


		
		return null;
	}
	
	/*
	 * Returns boolean based on if username and password match input
	 */
	public static Boolean validateLogin(String userName, String userPassword) {
		final String USERNAME = "john";
		final String PASSWORD = "password123";
		
		if (userName.equals(USERNAME) && userPassword.equals(PASSWORD)) {
			return true;
		}
		return false;
	}
	
	
	
	
}
