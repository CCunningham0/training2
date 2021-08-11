package bank;

public class User {
	private int id; // must be unique
	private String name;
	private String password;
	private String userType; // customer or employee
	
	public User() {};
	
	public User(int id, String name, String password, String userType) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.userType = userType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
