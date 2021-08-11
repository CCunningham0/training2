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
	public void addUser(User user) throws SQLException {
		String sql = "insert into users (name, password, user_type) values (?, ?, ?)";
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getUserType());
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("Added customer!");
		else
			System.out.println("Sorry, an issue as occured.");
	}

	@Override
	public List<User> getUsers() throws SQLException {
		String sql = "select * from users";
		statement = conn.createStatement();
		List<User> users = new ArrayList<User>();
		ResultSet resultSet = statement.executeQuery(sql);
		User user;
		
		while (resultSet.next()) {
			user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
			users.add(user);
		}
		
		return users;
	}

	@Override
	public User getUserById(int id) throws SQLException {
		User user = new User();
		String sql = "select * from users where id = " + id;
		statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		resultSet.next();
		
		if (resultSet != null) {
			user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
		} else {
			System.out.println("No record found.");
		}
		return user;
	}
}
