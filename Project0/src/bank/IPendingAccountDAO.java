package bank;

import java.sql.SQLException;
import java.util.List;

public interface IPendingAccountDAO {
	void addPendingAccount(PendingAccount pendingAccount) throws SQLException;
	void removePendingAccount(PendingAccount pendingAccount) throws SQLException;
	
	List<PendingAccount> getPendingAccounts() throws SQLException;
	PendingAccount getPendingAccountById(int id) throws SQLException;
}

