package bank;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
	void addCustomer(User customer) throws SQLException;
	List<User> getCustomers() throws SQLException;
	User getCustomerById(int id) throws SQLException;
}
