package logic.entity;

public class User {
	protected String username;
	protected String emailAddress;
	protected String password;
	
	public User() {
		this.username = "";
		this.emailAddress = "";
		this.password = "";
	}
	
	public boolean isAdmin() {
		return false;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @override of Object method toString
	 */
	@Override
	public String toString() {
		return String.format("utente: '%s' %nemail: '%s' %npassword: '%s'" , this.username , this.emailAddress , this.password ) ;
	}

	
}
