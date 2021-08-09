package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAOImpl implements IUser {
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	Connection conn = null;
	
	public UserDAOImpl() {
		this.conn = ConnectionFactory.getConnection();
	}

	@Override
	public void addCustomer(IUser customer) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into table_name (name, email) values (?, ?)";
//		preparedStatement.setString(1, employee.getName());
//		preparedStatement.setString(2, employee.getEmail());
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("table_name saved!");
	}

	@Override
	public List<IUser> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IUser getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
