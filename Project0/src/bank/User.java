package bank;

/*
 * User class for...
 */
public class User {
	public String username;
	public String userType;
	// FIXME: accounts array?
	
	/*
	 * Sets the user properties
	 */
	public User(String username, String userType) {
		//super(username, userType); FIXME: super is currently object class
		
		this.username = username;
		this.userType = userType;
	}
}
