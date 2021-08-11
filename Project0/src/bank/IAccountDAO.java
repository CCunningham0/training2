package bank;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDAO {
	void addAccount(Account account) throws SQLException;
	
	void withdrawFunds(Account account, double amount) throws SQLException;
	void depositFunds(Account account, double amount) throws SQLException;
	void transferFunds(Account sendingAccount, Account recievingAccount,  double amount) throws SQLException;
	void acceptTransfer(Account account) throws SQLException; //accept fund transfer from another account??
	
	List<Account> getAccounts() throws SQLException;
	Account getAccountById(int id) throws SQLException;
	double getAccountBalance(int id) throws SQLException;
}
