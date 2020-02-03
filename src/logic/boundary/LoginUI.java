package logic.boundary;

import logic.implementation.Credentials;

public class LoginUI extends Credentials {
	private String username;
	private String password;
	
	public boolean isValid(String name, String pass) {
		this.username = name;
		this.password = pass;
		return super.isValid(this.username, this.password);
	}	
	
}
