package bank;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class UserDAOImplTest {

	@Test
	void testUserDAOImpl() {
		fail("Not yet implemented");
	}

	@Test
	void testAddCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCustomers() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCustomerById() throws SQLException {
		IUserDAO userDao = new UserDAOImpl();
		int id = 1;
		
		assertNull(userDao.getUserById(-1));
		if (userDao.getUserById(id) != null) {
			assertEquals(id, userDao.getUserById(id).getId());
			assertNotNull(userDao.getUserById(id));
		}
		
		fail("Not yet implemented");
	}

}
