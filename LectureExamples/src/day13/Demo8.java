package day13;

class InSufficientFundException extends Exception {
	public InSufficientFundException() {
		System.out.println("Insufficient amount requested");
	}
	
	public InSufficientFundException(String message) {
		System.out.println(message);
	}
}

class BankAccount {
	private int bal = 0;
	private int accountNum;
	
	public BankAccount(int accountNum) {
		this.accountNum = accountNum;
	}
	
	public void deposit(int amount) {
		bal += amount;
		System.out.println("Amount credited: " + amount);
	}
	
	public void withdraw(int amount) throws InSufficientFundException {
		if (amount <= bal) {
			System.out.println("Amount debited: " + amount);
		} else {
			throw new InSufficientFundException("Not enough balance");
		}
	}
	
	public int getBal() {
		return bal;
	}
	
	public int getAccNum() {
		return accountNum;
	}
}

public class Demo8 {
	public static void main(String[] args) {
		 int a = 40;
		 int b = 0;
		 //int c = a / b;
		 //System.out.println(c); // Cannot divide by zero > ArithmeticException
		 
		 // Custom exception demo
		 BankAccount account = new BankAccount(123456);
		 System.out.println(account.getBal());
		 account.deposit(5000);
		 
		 try {
			 account.withdraw(2000);
		 } catch (InSufficientFundException e) {
			 e.printStackTrace();
		 }
		 
		 account.deposit(1000);
		 try {
			 account.withdraw(10000);
		 } catch (InSufficientFundException e) {
			 e.printStackTrace();
		 }
	}
}
