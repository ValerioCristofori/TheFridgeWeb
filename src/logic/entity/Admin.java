package logic.entity;

public class Admin extends User{
	/**
	 * @param Username
	 * 
	 * @param Password
	 * 
	 * @param EmailAddress
	 */
	
	@Override
	public boolean isAdmin() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("admin: " + this.username + "\n" + "email: " + this.emailAddress + "\n" + "password: " + this.password );
	}
	
}
