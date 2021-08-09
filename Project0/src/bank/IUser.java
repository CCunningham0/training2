package bank;

import java.sql.SQLException;
import java.util.List;

public interface IUser {
	void addCustomer(IUser customer) throws SQLException;
	List<IUser> getCustomers();
	IUser getCustomerById(int id);
}
