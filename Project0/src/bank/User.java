package bank;

public class User {
	private int id; // must be unique
	private String name;
	private String userType; // customer or employee
	
	public User() {};
	
	public User(int id, String name, String userType) {
		this.id = id;
		this.name = name;
		this.userType = userType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
