package bank;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
	void addUser(User customer) throws SQLException;
	List<User> getUsers() throws SQLException;
	User getUserById(int id) throws SQLException;
}
