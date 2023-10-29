package project;
/*Project: Vehicular Cloud
 *Class: User.java
 *By: Miracle Sanchez 
 * 
 * */
public class User {
	private String firstName;
	private String lastName;
	private String password;
	private int clientID;
	private String userType;
	
	public User(String firstName, String lastName, String password, int clientID, String userType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.clientID=clientID;
		this.userType = userType;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public String getlastName() {
		return this.lastName;
	}
	
	public void setlastName(String name) {
		this.lastName = name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return this.userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
//	
//	public String getEmail() {
//		return this.email;	
//	}
//	
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	
	public int getId() {
		return this.clientID;
	}
	
	public void setId(int id) {
		this.clientID = id;
	}
	
}
