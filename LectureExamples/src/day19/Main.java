package day19;

import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {	
		Employee employee = new Employee();
		Employee employee2 = new Employee();
		
		// data to insert
		employee.setId(1);
		employee.setName("Mark");
		employee.setEmail("m@gmail.com");
		
		employee2.setId(1);
		employee2.setName("John");
		employee2.setEmail("j@gmail.com");
		
		
		EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDao(); // get EmployeeDAO object
		dao.addEmployee(employee);
		//dao.updateEmployee(employee2);
	
		//dao.deleteEmployee(1);
		
		dao.getEmployees();
	}
}
