package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/*
 * DAO is naming convention for class that just returns object
 */
public class EmployeeDAOImpl implements IEmployee {
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	Connection conn = null;
	
	public EmployeeDAOImpl() {
		this.conn = ConnectionFactory.getConnection();
//		Connection conn = ConnectionFactory.getConnection();
//		statement = conn.createStatement();
	}
	
	@Override
	public void addEmployee(IEmployee employee) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into table_name (name, email) values (?, ?)";
//		preparedStatement.setString(1, employee.getName());
//		preparedStatement.setString(2, employee.getEmail());
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occured
			System.out.println("table_name saved!");
	}

	@Override
	public void updateEmployee(IEmployee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IEmployee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEmployee employeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
