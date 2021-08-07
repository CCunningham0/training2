package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/*
 * Class to create and return connection object
 * **Each class creating their own connection object to run methods for sql would be inefficient
 * **Factory in class name -> class is responsible for creating object
 */
public class ConnectionFactory {
	private static Connection conn = null;
	
	private ConnectionFactory() {};
	
	
	
	public static Connection getConnection() {
		if(conn == null) {
			// accessing properties file
			ResourceBundle bundle = ResourceBundle.getBundle("bank/dbConfig");
			String url = bundle.getString("url");
			String username = bundle.getString("username");
			String password = bundle.getString("password");
			
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		return null;
	}
}
