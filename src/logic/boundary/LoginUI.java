package logic.boundary;

import logic.implementation.Credentials;

public class LoginUI extends Credentials {
	
	public boolean isValid(String username, String password) {
		return super.isValid(username, password);
	}	
	
}
