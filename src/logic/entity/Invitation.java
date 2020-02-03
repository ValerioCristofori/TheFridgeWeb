package logic.entity;

public class Invitation {
	private String invitingUser; 
	private String invitedEmail;
	private String invitedUser;
	private String message;
	
	public Invitation() {
		this.setInvitingUser("");
		this.setInvitedUser("");
		this.message = "";
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the invitingUser
	 */
	public String getInvitingUser() {
		return invitingUser;
	}

	/**
	 * @param invitingUser the invitingUser to set
	 */
	public void setInvitingUser(String invitingUser) {
		this.invitingUser = invitingUser;
	}

	/**
	 * @return the invitedUser
	 */
	public String getInvitedUser() {
		return invitedUser;
	}

	/**
	 * @param invitedUser the invitedUser to set
	 */
	public void setInvitedUser(String invitedUser) {
		this.invitedUser = invitedUser;
	}
	
	@Override
	public String toString() {
		return String.format( "Invitation from: '%s' to: '%s' %nMessage: '%s'", this.invitingUser , this.invitedUser , this.message );
	}

	/**
	 * @return the invitedEmail
	 */
	public String getInvitedEmail() {
		return invitedEmail;
	}

	/**
	 * @param invitedEmail the invitedEmail to set
	 */
	public void setInvitedEmail(String invitedEmail) {
		this.invitedEmail = invitedEmail;
	}
	
}
