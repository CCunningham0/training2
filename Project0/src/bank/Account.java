package bank;

public class Account {
	private int id;
	private String name;
	private String userId;
	
	public Account() {};
	
	public Account(int id, String name, String userId) {
		this.id = id;
		this.name = name;
		this.userId = userId;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
