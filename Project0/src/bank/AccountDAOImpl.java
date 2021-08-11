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
	public void addAccount(Account account, User user) throws SQLException {
		String sql = "insert into accounts (user_id, account_type, balance) values (?, ?, ?)";
		preparedStatement = conn.prepareStatement(sql);
		
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, account.getAccountType());
		preparedStatement.setDouble(3, account.getAccountBalance());
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("Added account!");
		
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
