package day18;

import java.sql.*;

public class JDBCDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/revature"; // standard url and name of database
		
		// Step 1: load driver -optional in our case
		//Class.forName(url);
		
		// Step 2: Create connection object
		Connection conn = DriverManager.getConnection(url, "root", "root");
		if (conn.isClosed()) {
			System.out.println("Connection failed.");
		} else {
			System.out.println("Connection successful.");
		}
		
		// Step 3: Create Statement object
		Statement statement = conn.createStatement();
		
		// Step 4: Execute query
		ResultSet resultSet = statement.executeQuery("select * from employee");
		while (resultSet.next()) {
			// **Note: this print statement only works if table columns in expected order
			System.out.println("Id: " + resultSet.getInt(1) + ", Name: "
                    + resultSet.getString(2) + ", Email: " + resultSet.getString(3));
        }
		
		
		// Demo 2 : create table
//		String query = "create table staff (id INTEGER PRIMARY KEY AUTO_INCREMENT, name CHAR(20), email CHAR(50))";
//		statement.executeUpdate(query);
//		System.out.println("Table created successfully");
		
		// Demo 2: insert data into table
//		String query = "insert into staff (name, email) values (?, ?)";
		
		// get prepareStatement object
//		PreparedStatement preparedStatement = conn.prepareStatement(query);
//		// set values to query
//		preparedStatement.setString(1, "Mark Smith"); // set first column (?)
//		preparedStatement.setString(2, "m@gmail.com"); // set second column (?)
//		// execute query
//		int rowsAffected = preparedStatement.executeUpdate();
//		System.out.println("(" + rowsAffected + ") rows affected");
		
		
		// Demo 2: update data in table
//		String query = "update staff set name = ?, email = ? where id = ?";
//		PreparedStatement preparedStatement = conn.prepareStatement(query);
//		preparedStatement.setString(1, "John");
//		preparedStatement.setString(2, "j@gmail.com");
//		preparedStatement.setInt(3, 1);
//		int rowAffected = preparedStatement.executeUpdate();
//		System.out.println("(" + rowAffected + ") rows affected");
		
		
		// Demo 2: delete data from table
//		String query = "delete from staff where id = ?";
//		PreparedStatement preparedStatement = conn.prepareStatement(query);
//		preparedStatement.setInt(1, 1);
//		int rowAffected = preparedStatement.executeUpdate();
//		System.out.println("(" + rowAffected + ") rows affected");
		
		// Demo 2: read data from table
		String query = "select * from staff";
		ResultSet resultSet2 = statement.executeQuery(query);
		
		while (resultSet2.next()) {
			int id = resultSet2.getInt(1);
			String name = resultSet2.getString(2);
			String email = resultSet2.getString(3);

			System.out.println("Id = " + id + ", name = " + name + ", email = " + email);
		}
		
		
		// Step 5: Close the connection
		System.out.println("Closing connection.");
		conn.close();
		
	}
}
