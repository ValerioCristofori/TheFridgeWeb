package logic.implementation.exceptions;

public class TooManyFridgesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String mess;
	
	public TooManyFridgesException( String message ) {
		this.mess = message;
	}

	/**
	 * @return the mess
	 */
	public String getMess() {
		return mess;
	}

	
}
