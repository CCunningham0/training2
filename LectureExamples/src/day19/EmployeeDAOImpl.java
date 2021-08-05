package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * **DAO is naming convention for class that just returns object
 */
public class EmployeeDAOImpl implements EmployeeDAO {
	private static Statement statement = null;
	Connection conn = null;
	
	public EmployeeDAOImpl() {
		this.conn = ConnectionFactory.getConnection();
	}
	
	@Override
	public void addEmployee(Employee employee) throws SQLException {
		String sql = "insert into employee (id, name, email) values (?, ?, ?)";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		int empId = 0;
		
//		while (employee.getId() <= getEmployeeById().getId()) {
//			count += employee.getId();
//		}
		
		preparedStatement.setInt(1, empId);
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setString(3, employee.getEmail());
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("employee saved!");
		else
			System.out.println("Something went wrong :(.");
	}

	@Override
	public void updateEmployee(Employee employee) throws SQLException {
		String sql = "update employee set name = ?, email = ? where id = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setString(2, employee.getEmail());
		preparedStatement.setInt(3, employee.getId());
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("employee updated!");
		else
			System.out.println("Something went wrong :(.");
	}

	@Override
	public void deleteEmployee(int id) throws SQLException {
		String sql = "delete from employee where id = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("employee deleted!");
		else
			System.out.println("Something went wrong :(.");
	}

	@Override
	public List<Employee> getEmployees() throws SQLException {
		statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employee");
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee;

		while (resultSet.next()) {
			employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			employees.add(employee);
			System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getEmail());
        }
	
		return employees;
	}

	@Override
	public Employee employeeById(int id) throws SQLException {
		List<Employee> currEmployees = getEmployees();
		
		for (int i = 0; i < currEmployees.size(); i++) {
			if ((currEmployees.get(i).getId()) == id){
				return currEmployees.get(i);
			}
		}
		return null;
	}

}
