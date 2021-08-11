package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements IAccountDAO{
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	Connection conn = null;
	
	public AccountDAOImpl() {
		this.conn = ConnectionFactory.getConnection();
	}
	
	@Override
	public void addAccount(Account account) throws SQLException {
		String sql = "insert into accounts (user_id, account_type, balance) values (?, ?, ?)";
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, account.getUserId());
		preparedStatement.setString(2, account.getAccountType());
		preparedStatement.setDouble(3, account.getAccountBalance());
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("Added account!");
		else
			System.out.println("Sorry, an issue as occured.");
	}

	@Override
	public void withdrawFunds(Account account, double amount) throws SQLException {
		String sql = "update accounts set balance = ? where id = ?";
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setDouble(1, account.getAccountBalance() - amount);
		preparedStatement.setInt(2, account.getId());
		
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("Withdrew funds!");
		else
			System.out.println("Sorry, an issue as occured.");
	}

	@Override
	public void depositFunds(Account account, double amount) throws SQLException {
		String sql = "update accounts set balance = ? where id = ?";
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setDouble(1, account.getAccountBalance() + amount);
		preparedStatement.setInt(2, account.getId());
		
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("Deposited funds!");
		else
			System.out.println("Sorry, an issue as occured.");
	}

	@Override
	public void transferFunds(Account sendingAccount, Account recievingAccount, double amount) throws SQLException {
		String sql = "update accounts set balance = ? where id = ?";
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setDouble(1, sendingAccount.getAccountBalance() - amount);
		preparedStatement.setInt(2, sendingAccount.getId());
		int count = preparedStatement.executeUpdate();
		
		sql = "update accounts set balance = ? where id = ?";
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setDouble(1, recievingAccount.getAccountBalance() + amount);
		preparedStatement.setInt(2, recievingAccount.getId());
		int count2 = preparedStatement.executeUpdate();
		
		if (count > 0 || count2 > 0) // if getting 0, issue has occurred
			System.out.println("Transfered funds!");
		else
			System.out.println("Sorry, an issue as occured.");	
	}

	@Override
	public void acceptTransfer(Account account) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> getAccounts() throws SQLException {
		String sql = "select * from accounts";
		statement = conn.createStatement();
		List<Account> accounts = new ArrayList<Account>();
		ResultSet resultSet = statement.executeQuery(sql);
		Account account;
		
		while (resultSet.next()) {
			account = new Account(resultSet.getInt(1), resultSet.getInt(2),resultSet.getString(3), resultSet.getDouble(4));
			accounts.add(account);
		}
		
		return accounts;
	}

	@SuppressWarnings("unused")
	@Override
	public Account getAccountById(int id) throws SQLException {
		Account account = new Account();
		String sql = "select * from accounts where id = " + id;
		statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		resultSet.next();
		
		if (resultSet != null) {
			account = new Account(resultSet.getInt(1), resultSet.getInt(2),resultSet.getString(3), resultSet.getDouble(4));
		} else {
			System.out.println("No record found.");
		}
		return account;
	}

	//FIXME: this method is redundant/unneeded 
	@SuppressWarnings("unused")
	@Override
	public double getAccountBalance(int id) throws SQLException {
		double accountBal = -1;
		String sql = "select * from accounts where id = " + id;
		statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		resultSet.next();
		
		if (resultSet != null) {
			accountBal = resultSet.getDouble(4);
		} else {
			System.out.println("No record found.");
		}
		return accountBal;
	}

}
