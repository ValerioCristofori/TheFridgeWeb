package logic.implementation.exceptions;

public class EmptyInvitationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String invitationMessage;
	
	public EmptyInvitationException( String mess ) {
		this.invitationMessage = mess;
	}

	/**
	 * @return the invitationMessage
	 */
	public String getInvitationMessage() {
		return invitationMessage;
	}


}
