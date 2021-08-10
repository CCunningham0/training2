package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	Connection conn = null;
	
	public UserDAOImpl() {
		this.conn = ConnectionFactory.getConnection();
	}

	@Override
	public void addCustomer(User user) throws SQLException {
		// don't insert Id and it auto-increments?
		String sql = "insert into users (name, userType) values (?, ?)";
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getUserType());
		int count = preparedStatement.executeUpdate(sql);
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("table_name saved!");
	}

	@Override
	public List<User> getCustomers() throws SQLException {
		statement = conn.createStatement();
		List<User> customers = new ArrayList<User>();
		String sql = "select * from users where user_type = 'customer'";
		ResultSet resultSet = statement.executeQuery(sql);
		User customer;
		
		while (resultSet.next()) {
			customer = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			customers.add(customer);
			//System.out.println(customer.getId() + " " + customer.getName());
		}
		
		return customers;
	}

	@Override
	public User getCustomerById(int id) throws SQLException {
		String sql = "select * from users where id = " + id;
		ResultSet resultSet = statement.executeQuery(sql);
		resultSet.next();
		User customer = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
		return customer;
	}
}
