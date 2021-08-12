package bank;

public class PendingAccount {
	private int id; // unique and auto-increments
	private int userId; // references users table
	private String accountType; // savings or checking
	private Double accountBalance; // account balance
	
	public PendingAccount() {};
	
	public PendingAccount(int id, int userId, String accountType, Double accountBalance) {
		this.id = id;
		this.userId = userId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
}
