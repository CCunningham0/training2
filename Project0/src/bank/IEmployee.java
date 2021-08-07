package bank;

import java.sql.SQLException;
import java.util.List;

public interface IEmployee {
	void addEmployee(IEmployee employee) throws SQLException;
	void updateEmployee(IEmployee employee);
	void deleteEmployee(int id);
	List<IEmployee> getEmployees();
	IEmployee employeeById(int id);
}
