package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AccountDAOImpl implements IAccountDAO{
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	Connection conn = null;
	
	public AccountDAOImpl() {
		this.conn = ConnectionFactory.getConnection();
	}
	
	@Override
	public void addAccount(User user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawFunds(int id, double amount) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositFunds(int id, double amount) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferFunds(int sendingAccountId, double amount, int recievingAccountId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptTransfer(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> getAccounts() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountBalance(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
