package logic.bean;

public class BeanShareFridge {
	private String invitingUsername;
	private String invitedUsername;
	private String invitedEmail;
	private String message;
	/**
	 * @return the invitingUsername
	 */
	public String getInvitingUsername() {
		return invitingUsername;
	}
	/**
	 * @param invitingUsername the invitingUsername to set
	 */
	public void setInvitingUsername(String invitingUsername) {
		this.invitingUsername = invitingUsername;
	}
	/**
	 * @return the invitedUsername
	 */
	public String getInvitedUsername() {
		return invitedUsername;
	}
	/**
	 * @param invitedUsername the invitedUsername to set
	 */
	public void setInvitedUsername(String invitedUsername) {
		this.invitedUsername = invitedUsername;
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
}
