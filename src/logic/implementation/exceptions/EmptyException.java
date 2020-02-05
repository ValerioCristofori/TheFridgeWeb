package logic.implementation.exceptions;

public class EmptyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String emptyMessage;
	
	public EmptyException( String mess ) {
		this.emptyMessage = mess;
	}

	/**
	 * @return the message
	 */
	public String getEmptyMessage() {
		return emptyMessage;
	}

}
