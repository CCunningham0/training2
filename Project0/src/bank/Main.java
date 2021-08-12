package bank;

import org.apache.log4j.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * Main class for Bank application - Project0
 */
public class Main {
	static Scanner scanner = new Scanner(System.in);
	private static final Logger log = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) throws SQLException {
		User user = new User();
		
		/*
		 * TODO:
		 * 	X. get input via scanner object
		 * 	X. create custom stored procedure to perform some functionality (i.e. store account info?)
		 * 	X. access database using JDBC and data access objects
		 * 	4. use log4j to log events in a file (learning Tuesday??)
		 * 	5. write at least 1 JUnit test
		 * 
		 */

		/*
		 * ## User Stories
		 * X As a user, I can login. 
		 * X As a customer, I can apply for a new bank account with a starting balance. 
		 * X As a customer, I can view the balance of a specific account. 
		 * X As a customer, I can make a withdrawal or deposit to a specific account. 
		 * 
		 * As the system, I reject invalid transactions. 
		 * Example: * A withdrawal that would result in a negative balance.
		 * A deposit or withdrawal of negative money. 
		 * 
		 * X As an employee, I can approve or reject an account. 
		 * X As an employee, I can view a customer's bank accounts. 
		 * 
		 * X As a user, I can register for a customer account. 
		 * 
		 * X As a customer, I can post a money transfer to another account. 
		 * As a customer, I can accept a money transfer from another account. 
		 * A an employee, I can view a log of all transactions.
		 */

		IUserDAO userDao = new UserDAOImpl();
		IAccountDAO accountDao = new AccountDAOImpl();
		IPendingAccountDAO pendingAccountDao = new PendingAccountDAOImpl();

		ConsoleAppender consoleAppender = new ConsoleAppender();
	    consoleAppender.setThreshold(Level.INFO);
	    consoleAppender.setLayout(new PatternLayout("%d [%p|%c|%c{1}]"));
        consoleAppender.activateOptions();
        LogManager.getRootLogger().addAppender(consoleAppender);
        
	    List<String> logs = new ArrayList<>();
		
		scanner.useDelimiter(System.lineSeparator());
		boolean running = true;

		// Pending transfers list
		List<PendingTransfer> pendingTransfers = new ArrayList<>();



		// Start of application
		System.out.println("****************************************\n");
		System.out.println("Welcome to the banking application!");
		System.out.println("\n*****************************************");
		System.out.println("To use the application, you must first sign in or create an account.");
		System.out.println("If you have an existing account, please enter 'yes'. Otherwise, enter 'no'.");
		String hasAccount = parseInputString("yes", "no");

		if (hasAccount.equals("no")) {
			System.out.println("To create a new account, please enter a username:");
			String newUsername = scanner.next();

			System.out.println("Please enter a password for your new account:");
			String newPassword = scanner.next();

			System.out.println("Please enter 'employee' or 'customer' as per your case.");
			String newUserType = scanner.next();

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

			System.out.println("Please enter your password.");
			String password = scanner.next().toLowerCase();
			
			if (!validateLogin(userId, password)) {
				System.out.println("Invalid login information");
				scanner.close();
				return;
			}

			user = userDao.getUserById(userId);
		} else {
			System.out.println("Please enter yes or no.");
			return;
		}
		System.out.println("*****************************************\n");
		System.out.println("Hello, you signed in as: " + user.getName() + "!");

		// Loop for action selection
		while (running) {
			System.out.println("\n*****************************************");
			// If user is customer
			int selection = 0;
			if (user.getUserType().equals("customer")) {
				System.out.println("Please enter the number for an action, the options are as follows:\n"
						+ "1. Apply for a new bank account.\n"
						+ "2. View the balance of an account.\n"
						+ "3. Withdraw from or deposit into an account.\n"
						+ "4. Create a pending money transfer to an account.\n"
						+ "5. Accept any pending transfers from another account.");
				selection = scanner.nextInt();

				switch (selection) {
					// Apply for new account
					case 1: {
						System.out.println("Please enter the type of account you would like to create"
								+ ", i.e.'checking' or 'savings':");
						String accountType = parseInputString("checking","savings");
						
						System.out.println("Please enter the initial balance for the account:");
						double accountBal = parseInputDouble();
						if (accountBal < 1) {
							System.out.println("Your cannot have a balance less than $1.00.");
							break;
						}
						PendingAccount newPendingAccount = new PendingAccount();
						newPendingAccount.setUserId(user.getId());
						newPendingAccount.setAccountType(accountType);
						newPendingAccount.setAccountBalance(accountBal);
						
						pendingAccountDao.addPendingAccount(newPendingAccount);
						String message = "Added new pending account " + newPendingAccount.getId() + " for user " + newPendingAccount.getUserId();
						System.out.println("Please enter yes or no");
						logs.add(message);
						break;
					}
	
					// View balance of customer's selected account
					// TODO: should only be allowed for current customer's accounts
					case 2: { 
						System.out.println("Please enter the account id:");
						int accountId = scanner.nextInt();
	
						System.out.println("Balance: " + accountDao.getAccountById(accountId).getAccountBalance());
						break;
					}
	
					// Withdraw from or deposit into customer's selected account
					// TODO: should only be allowed for current customer's accounts
					case 3: {
						System.out.println("Please enter either 'deposit' or 'withdraw':");
						String action = parseInputString("deposit", "withdraw");
						if (action.equals("null")) {
							System.out.println("Invalid action.");
							break;
						}
						
						System.out.println("Please enter the account id:");
						int accountId = scanner.nextInt();
						Account account = accountDao.getAccountById(accountId);
	
						if (action.equals("deposit")) {
							System.out.println("Please enter the amount you would like to deposit:");
							double amount = scanner.nextDouble();
							if (amount <= 1) {
								System.out.println("Deposit amount cannot be less than $1.00.");
								break;
							}
							accountDao.depositFunds(account, amount);
							System.out.println("Deposited $" + amount + " into account " + accountId + ".");
							String message = "Deposited " + amount + " into account " + account.getId() + " for user " + account.getUserId();
							System.out.println("Please enter yes or no");
							logs.add(message);
	
						} else if (action.equals("withdraw")) {
							System.out.println("Please enter the amount you would like to withdraw:");
							double amount = scanner.nextDouble();
							if (amount <= 1) {
								System.out.println("Withdrawl amount cannot be less than $1.00.");
								break;
							} 
							if (amount > account.getAccountBalance()) {
								System.out.println("Withdrawl amount cannot be more than the current account balance.");
								break;
							}
							accountDao.withdrawFunds(account, amount);
							System.out.println("Withdrew $" + amount + " from account " + accountId + ".");
							String message = "Withdrew " + amount + "from account " + account.getId() + " for user " + account.getUserId();
							System.out.println("Please enter yes or no");
							logs.add(message);
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
						double amount = scanner.nextDouble();
						
						if (amount <= 1) {
							System.out.println("Cannot transfer less than $1.00.");
							break;
						}
						if (amount > transferAccount.getAccountBalance()) {
							System.out.println("Cannot transfer more than the account balance.");
							break;
						}
						
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
						// TODO: reused loop is inefficient, should combine the two
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
							System.out.println("Transfer id " + pendingTransfer.getTransferId() + " of $" + pendingTransfer.getAmount() + " from account " 
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
					// Case for invalid input
					default: System.out.println("Please enter a number between 1 and 5.");
				}
			}

			// if user is employee
			if (user.getUserType().equals("employee")) {
				System.out.println("Please enter the number for an action, the options are as follows:\n"
						+ "1. Approve or reject a pending account.\n"
						+ "2. View customer's bank accounts.\n"
						+ "3. View transaction log for account(s).");
				selection = scanner.nextInt();

				switch (selection) {
					// Approve or reject a customer's pending account
					case 1: {
						PendingAccount pendingAccount;	
					
						System.out.println("The pending accounts are as follows:");
						if (pendingAccountDao.getPendingAccounts().size() == 0) {
							System.out.println("There are currently no pending accounts.");
							break;
						}
						for (Iterator<PendingAccount> iter = pendingAccountDao.getPendingAccounts().iterator(); iter.hasNext();) {
							pendingAccount = iter.next();
							System.out.println("Pending account ID: " + pendingAccount.getId() + " | user ID: " + pendingAccount.getUserId()
								+ " | account type: " + pendingAccount.getAccountType() + " | account balance: " + pendingAccount.getAccountBalance());
						}
						
						System.out.println("Please select a pending account to manage by entering its ID:");
						int pAccountId = scanner.nextInt();
						pendingAccount = pendingAccountDao.getPendingAccountById(pAccountId);
						
						System.out.println("Please choose to either reject or accept the account by entering 'reject' or 'accept':");
						String action = parseInputString("reject", "accept");
								
						if (action.equals("reject")) {
							pendingAccountDao.removePendingAccount(pendingAccount);
							String message = "Rejected pending account " + pendingAccount.getId() + " for user " + pendingAccount.getUserId();
							System.out.println("Please enter yes or no");
							logs.add(message);
							break;
						} 
						
						if (action.equals("accept")) {
							Account newAccount = new Account();
							newAccount.setUserId(pendingAccount.getUserId());
							newAccount.setAccountType(pendingAccount.getAccountType());
							newAccount.setAccountBalance(pendingAccount.getAccountBalance());
							
							accountDao.addAccount(newAccount);
							String message = "Added new account " + newAccount.getId() + " for user " + newAccount.getUserId();
							System.out.println("Please enter yes or no");
							logs.add(message);
							pendingAccountDao.removePendingAccount(pendingAccount);
							message = "Accepted pending account " + pendingAccount.getId() + " for user " + pendingAccount.getUserId();
							System.out.println("Please enter yes or no");
							logs.add(message);
						} 
						
						if (action.equals(null)) {
							System.out.println("Invalid action.");
							break;
						}
						break;
					}
					
					// View a customer's accounts
					case 2: {
						System.out.println("Please enter the customer's ID number:");
						int custId = scanner.nextInt();
						Account custAccount;
						
						if (custId < 0 || custId > accountDao.getAccounts().size()) {
							System.out.println("Customer not found.");
							break;
						}
						
						for (Iterator<Account> iter = accountDao.getAccounts().iterator(); iter.hasNext();) {
							custAccount = iter.next();
							if (custAccount.getUserId() == custId)
								if (userDao.getUserById(custId).getUserType().equals("employee")) {
									System.out.println("Sorry, you cannot view other employee's accounts.");
									break;
								}
								User customer = userDao.getUserById(custId);
								System.out.println("Customer ID: " + custId + " | name: " + customer.getName()
										+ " | account ID: " + custAccount.getId() + " | account type: " + custAccount.getAccountType()
										+ " | account balance: " + custAccount.getAccountBalance());
						}
						
						break;
					}
					
					// View log of all transactions
					case 3: {
						// TODO: write to then read logs from file?
						System.out.println("Recorded logs:");
						for (Iterator<String> iter = logs.iterator(); iter.hasNext();) {
							String log = iter.next();	
							System.out.println("-" + log);
						}
						break;
					}
					
					// Invalid input
					default: System.out.println("Please enter a number between 1 and 3.");
				}
			}

		}
		scanner.close();

	}

	/*
	 * Get input from user with scanner object
	 */
	public static Double parseInputDouble(Double...values) {
		scanner.useDelimiter(System.lineSeparator());
		Double input = null;
		try {
			input = scanner.nextDouble();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (input > 0) 
			return input;
		
		return -1.00;
	}

	/*
	 * Validate and parse user input and return result
	 */
	public static String parseInputString(String...values) {
		scanner.useDelimiter(System.lineSeparator());
		String input = null;
		try {
			input = scanner.next().toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		for (int i = 0; i < values.length; i++) {
			if (input.equals(values[i])) {
				//System.out.println("Compared input: " + input + " to " + values[i]);
				return input;
			}
		}
		return "null";
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
