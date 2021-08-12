package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PendingAccountDAOImpl implements IPendingAccountDAO{
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	Connection conn = null;
	
	public PendingAccountDAOImpl() {
		this.conn = ConnectionFactory.getConnection();
	}
	
	@Override
	public void addPendingAccount(PendingAccount pendingAccount) throws SQLException {
		String sql = "insert into pendingAccounts (user_id, account_type, balance) values (?, ?, ?)";
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, pendingAccount.getUserId());
		preparedStatement.setString(2, pendingAccount.getAccountType());
		preparedStatement.setDouble(3, pendingAccount.getAccountBalance());
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("Added pending account!");
		else
			System.out.println("Sorry, an issue as occured.");
	}

	@Override
	public void removePendingAccount(PendingAccount pendingAccount) throws SQLException {
		String sql = "delete from pendingAccounts where id = " + pendingAccount.getId();
		preparedStatement = conn.prepareStatement(sql);
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("Removed pending account!");
		else
			System.out.println("Sorry, an issue as occured.");
		
	}

	@Override
	public List<PendingAccount> getPendingAccounts() throws SQLException {
		String sql = "select * from pendingAccounts";
		statement = conn.createStatement();
		List<PendingAccount> pendingAccounts = new ArrayList<PendingAccount>();
		ResultSet resultSet = statement.executeQuery(sql);
		PendingAccount pendingAccount;
		
		while (resultSet.next()) {
			pendingAccount = new PendingAccount(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getDouble(4));
			pendingAccounts.add(pendingAccount);
		}
		
		return pendingAccounts;
	}

	@Override
	public PendingAccount getPendingAccountById(int id) throws SQLException {
		PendingAccount pendingAccount = new PendingAccount();
		String sql = "select * from pendingAccounts where id = " + id;
		statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		resultSet.next();
		
		if (resultSet != null) {
			pendingAccount =  new PendingAccount(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getDouble(4));
		} else {
			System.out.println("No record found.");
		}
		return pendingAccount;
	}

}
