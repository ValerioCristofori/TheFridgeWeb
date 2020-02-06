package logic.implementation.exceptions;

public class DuplicatedUsernameException extends Exception{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicatedUsernameException(String username) {
		super("ERROR: username " + username + " already exists");
	}
}
