package bank;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDAO {
	void addAccount(Account account, User user) throws SQLException;
	
	void withdrawFunds(int id, double amount) throws SQLException;
	void depositFunds(int id, double amount) throws SQLException;
	void transferFunds(int sendingAccountId, double amount, int recievingAccountId) throws SQLException;
	void acceptTransfer(int id) throws SQLException; //accept fund transfer from another account??
	
	List<Account> getAccounts() throws SQLException;
	Account getAccountById(int id) throws SQLException;
	Account getAccountBalance(int id) throws SQLException;
}
