package bank;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * Main class for Bank application - Project0
 */
public class Main {
	
	public static void main(String[] args) throws SQLException {
		User user = new User();
		/*
		 * TODO:
		 * 	1. get input via scanner object
		 * 	2. create custom stored procedure to perform some functionality (i.e. store account info?)
		 * 	3. access database using JDBC and data access objects
		 * 	4. use log4j to log events in a file (learning Tuesday??)
		 * 	5. write at least 1 JUnit test
		 * 
		 */
		
		/*
		 * ## User Stories
		 * As a user, I can login. 
		 * As a customer, I can apply for a new bank account with a starting balance. 
		 * As a customer, I can view the balance of a specific account. 
		 * As a customer, I can make a withdrawal or deposit to a specific account. 
		 * 
		 * As the system, I reject invalid transactions. 
	 	 * Example: * A withdrawal that would result in a negative balance.
		 * A deposit or withdrawal of negative money. 
		 * 
		 * As an employee, I can approve or reject an account. 
		 * As an employee, I can view a customer's bank accounts. 
		 * 
		 * As a user, I can register for a customer account. 
		 * 
		 * As a customer, I can post a money transfer to another account. 
		 * As a customer, I can accept a money transfer from another account. 
		 * A an employee, I can view a log of all transactions.
		 */
		
		
		
		// TESTING
		/*
		System.out.println("Testing...");
		
		// UserDAOImpl method basic functionality working
		// FIXME: add validation/error handling
		/*
		UserDAOImpl userImpl = new UserDAOImpl();
		try {
			//if (userImpl.getUsers().size() == 0) {
				//System.out.println("Table is empty!");
				User userTest = new User();
				// data to insert (id created & incremented automatically)
				userTest.setName("Moe2");
				userTest.setPassword("iwantin");
				userTest.setUserType("customer");	
				
				IUserDAO dao = new UserDAOImpl();
				
				
				//userImpl.addUser(userTest);
				
				
				System.out.println(userImpl.getUsers());
			//}
			
			//List<User> temp = userImpl.getCustomers(); // returns User list of users

			// iterate through list
			for (Iterator<User> iter = userImpl.getUsers().iterator(); iter.hasNext();) {
				User userIter = iter.next();
				System.out.println("User id: " + userIter.getId() + ", name: " + userIter.getName());
			}
		
			User temp = userImpl.getUserById(1); // returns User object
			System.out.println("User id: " + temp.getId() + ", name: " + temp.getName());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		S
		System.out.println("*****************************************");
		// ** InterfaceDAO of new DAOImpl is needed to call getById without null pointer exception!!!	
		IAccountDAO daoAcc = new AccountDAOImpl();
		
		Account newAccount = new Account(); // **not setting new account values in constructor because we don't want to manually set id
//		newAccount.setUserId(2);
//		newAccount.setAccountType("checking"); // validation example: string should only be 'checking' or 'savings'
//		newAccount.setAccountBalance(100.00); // if no decimal included, must be cast from int to double
		
		try {
//			System.out.println("Getting user by ID...");
//			userTest = daoUser.getUserById(1);
//			System.out.println("GOT USER: " + userTest.getId() + " " + userTest.getName());
			
			newAccount = daoAcc.getAccountById(3);
			Account recAccount = daoAcc.getAccountById(4);
			//daoAcc.addAccount(newAccount);
			//daoAcc.withdrawFunds(newAccount, 50);
			//daoAcc.depositFunds(newAccount, 100);
			//daoAcc.transferFunds(newAccount, 50, recAccount);
			// iterate through list
//			for (Iterator<Account> iter = daoAcc.getAccounts().iterator(); iter.hasNext();) {
//				Account accIter = iter.next();
//				System.out.println("Account id: " + accIter.getId() + ", User id: " + accIter.getUserId());
//			}
			//System.out.println(daoAcc.getAccountBalance(4));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		System.out.println("Done testing...");
		*/
		
		
		

		IUserDAO userDao = new UserDAOImpl();
		IAccountDAO accountDao = new AccountDAOImpl();
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		// Pending transfers list
		List<PendingTransfer> pendingTransfers = new ArrayList<>();
		
		
	
		// Start of application
		System.out.println("*****************************************");
		System.out.println("Welcome to the banking application!");
		System.out.println("*****************************************");
		System.out.println("To use the application, you must first sign in or create an account.");
		System.out.println("If you have an existing account, please enter 'yes'. Otherwise, enter 'no'.");
		String hasAccount = scanner.nextLine().toLowerCase();
		
		if (hasAccount.equals("no")) {
			System.out.println("To create a new account, please enter a username:");
			String newUsername = scanner.nextLine();
			
			System.out.println("Please enter a password for your new account:");
			String newPassword = scanner.nextLine();
			
			System.out.println("Please enter 'employee' or 'customer' as per your case.");
			String newUserType = scanner.nextLine(); //FIXME: call getInput method so validation can be done

			user.setId(userDao.getUsers().size() + 1);
			user.setName(newUsername);
			user.setPassword(newPassword);
			user.setUserType(newUserType);
			userDao.addUser(user);
			
			System.out.println("Successfully created new account!");
			System.out.println("Your user ID is: " + user.getId() + ". You will use this to login from now on.");
			
		} else if (hasAccount.equals("yes")) {
			System.out.println("Please enter your user ID.");
			int userId = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Please enter your password.");
			String password = scanner.nextLine().toLowerCase();
			
			if (!validateLogin(userId, password)) {
				System.out.println("Invalid login information");
				scanner.close();
				return;
			}
			
			user = userDao.getUserById(userId);
		}
		System.out.println("*****************************************");
		System.out.println("Hello, you signed in as: " + user.getName() + "!");
			
		while (running) {
			System.out.println("\n*****************************************");
			// if user is customer
			int selection = 0;
			if (user.getUserType().equals("customer")) {
				System.out.println("Please enter the number for an action, the options are as follows:\n"
						+ "1. Apply for a new bank account.\n"
						+ "2. View the balance of an account.\n"
						+ "3. Withdraw from or deposit into an account.\n"
						+ "4. Create a pending money transfer to an account.\n"
						+ "5. Accept any pending transfers from another account.");
				selection = scanner.nextInt();
			}
			
			// if user is employee
			if (user.getUserType().equals("employee")) {
				System.out.println("Please enter the number for an action, the options are as follows:\n"
						+ "1. Approve or reject a pending account.\n"
						+ "2. View customer's bank accounts.\n"
						+ "3. Create a new account.\n"
						+ "4. View transaction log for account(s).");
				selection = scanner.nextInt();
			}
			
			
			switch (selection) {
				// Apply for new account
				case 1: {
					System.out.println("Please enter the type of account you would like to create"
							+ ", i.e.'checking' or 'savings':");
					String accountType = scanner.nextLine();
					scanner.next();
					
					System.out.println("Please enter the initial balance for the account:");
					double accountBal = scanner.nextDouble();
					
					Account newAccount = new Account();
					newAccount.setUserId(user.getId());
					newAccount.setAccountType(accountType);
					newAccount.setAccountBalance(accountBal);
					
					accountDao.addAccount(newAccount);
					break;
				}
				
				// View balance of customer's selected account
				case 2: { //FIXME: should only be allowed for current customer's accounts
					System.out.println("Please enter the account id:");
					int accountId = scanner.nextInt();
					
					System.out.println("Balance: " + accountDao.getAccountById(accountId).getAccountBalance());
					break;
				}
				
				// Withdraw from or deposit into customer's selected account
				case 3: {
					System.out.println("Please enter either 'deposit' or 'withdraw':");
					String action = scanner.next().toLowerCase();
					//scanner.nextLine();
					
					System.out.println("Please enter the account id:");
					int accountId = scanner.nextInt();
					Account account = accountDao.getAccountById(accountId);
					
					System.out.println("ACTION: " + action);
					if (action.equals("deposit")) {
						System.out.println("Please enter the amount you would like to deposit:");
						double amount = scanner.nextDouble();
						accountDao.depositFunds(account, amount);
						System.out.println("Deposited $" + amount + " into account " + accountId + ".");
						
					} else if (action.equals("withdraw")) {
						System.out.println("Please enter the amount you would like to withdraw:");
						double amount = scanner.nextDouble();
						accountDao.withdrawFunds(account, amount);
						System.out.println("Withdrew $" + amount + " from account " + accountId + ".");
					}
					break;
				}
				
				// Create pending money transfer to account
				case 4: { //FIXME: Both accounts should be owned by the customer
					System.out.println("Please enter the account ID you would like to transfer from:");
					int transferAccountId = scanner.nextInt();
					Account transferAccount = accountDao.getAccountById(transferAccountId);
					
					System.out.println("Please enter the account ID you would like to transfer to");
					int receivingAccountId = scanner.nextInt();
					Account receivingAccount = accountDao.getAccountById(receivingAccountId);
					
					System.out.println("Please enter the amount you would like to transfer:");
					//FIXME: cannot be greater than current account balance (or less than 1 cent)
					double amount = scanner.nextDouble();
			
					PendingTransfer pendingTransfer = new PendingTransfer(
							pendingTransfers.size() + 1,
							user.getId(), 
							transferAccountId, 
							receivingAccountId, 
							amount);
					pendingTransfers.add(pendingTransfer);	
					System.out.println("Successfully created pending transfer " + pendingTransfer.getTransferId() + " of $" 
							+ amount + " from account " + transferAccountId + " to account " + receivingAccountId + ".");	
					break;
				}
				
				// Accept any pending transfers
				case 5: {
					if (pendingTransfers.size() <= 0) {
						System.out.println("You have no pending transfers.");
						break;
					}
					
					PendingTransfer pendingTransfer = new PendingTransfer();
					List<PendingTransfer> myPendingTransfers = new ArrayList<>();
					
					// iterate through list of pending transfers and check for any for user
					for (Iterator<PendingTransfer> iter = pendingTransfers.iterator(); iter.hasNext();) {
						pendingTransfer = iter.next();					
						if (pendingTransfer.getUserId() == user.getId()) {
							myPendingTransfers.add(pendingTransfer);
						}
					}
					
					if (myPendingTransfers.size() <= 0) {
						System.out.println("You have no pending transfers.");
						break;
					}
						
					System.out.println("Your pending transfers are: ");
					for (Iterator<PendingTransfer> iter = myPendingTransfers.iterator(); iter.hasNext();) {
						pendingTransfer = iter.next();
						System.out.println("Transfer of $" + pendingTransfer.getAmount() + " from account " 
								+ pendingTransfer.getTransferAccountId() + " to account "
								+ pendingTransfer.getReceiveAccountId() + ".");
					}
					
					PendingTransfer myPendingTransfer = new PendingTransfer();
					while (myPendingTransfers.size() > 0) {
						System.out.println("Please select a transfer to accept by entering the id, or quit accepting "
								+ "transfers by entering '-1':");
						int actionNum = scanner.nextInt();
						
						if (actionNum == -1)
							break;
						
						for (Iterator<PendingTransfer> iter = myPendingTransfers.iterator(); iter.hasNext();) {
							pendingTransfer = iter.next();
							if (pendingTransfer.getTransferId() == actionNum)
								myPendingTransfer = pendingTransfer;
						}
						
						Account transferAcc = accountDao.getAccountById(myPendingTransfer.getTransferAccountId());
						Account recAcc = accountDao.getAccountById(myPendingTransfer.getReceiveAccountId());
						
						accountDao.transferFunds(transferAcc, recAcc, myPendingTransfer.getAmount());
						System.out.println("Accepted pending transfer " + myPendingTransfer.getTransferId() + "!");
						if (myPendingTransfers.size() == 0) {
							System.out.println("You have no other pending transfers.");
							break;
						}
					}
					break;			
				}
				
				default: System.out.println("Please enter a number between 1 and 5.");
		
			}
		
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
		if (user.getUserType().equals("customer")) {
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
	public static Boolean validateLogin(int userId, String userPassword) throws SQLException {
		IUserDAO dao = new UserDAOImpl();
		User user;
		for (Iterator<User> iter = dao.getUsers().iterator(); iter.hasNext();) {
			user = iter.next();			
			if (user.getId() == userId && user.getPassword().equals(userPassword)) {
				return true;
			}	
		}
		return false;
	}
	
}
