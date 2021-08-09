package bank;

import java.sql.SQLException;
import java.util.List;

public interface IAccount {
	void addAccount(IUser customer) throws SQLException;
	
	void withdrawFunds(int id, double amount) throws SQLException;
	void depositFunds(int id, double amount) throws SQLException;
	void transferFunds(int sendingAccountId, double amount, int recievingAccountId) throws SQLException;
	void acceptTransfer(int id) throws SQLException; //accept fund transfer from another account??
	
	List<IAccount> getAccounts() throws SQLException;
	IAccount getAccountById(int id) throws SQLException;
	IAccount getAccountBalance(int id) throws SQLException;
}
