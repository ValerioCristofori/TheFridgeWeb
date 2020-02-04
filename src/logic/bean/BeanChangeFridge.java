package logic.bean;

import java.util.ArrayList;
import java.util.List;

import logic.entity.Invitation;

public class BeanChangeFridge {
	private int fridgeId;
	private String invitingUser;
	private ArrayList<Invitation> invitationList;
	private ArrayList<String> listOfNameFridges;
	private int[] listOfId;
	

	/**
	 * @return the listOfNameFridges
	 */
	public List<String> getListOfNameFridges() {
		return listOfNameFridges;
	}

	/**
	 * @param listOfNameFridges the listOfNameFridges to set
	 */
	public void setListOfNameFridges(List<String> listOfNameFridges) {
		this.listOfNameFridges = (ArrayList<String>) listOfNameFridges;
	}
	
	/**
	 * @return the invitationList
	 */
	public List<Invitation> getInvitationList() {
		return invitationList;
	}

	/**
	 * @param invitationList the invitationList to set
	 */
	public void setInvitationList(List<Invitation> invitationList) {
		this.invitationList = (ArrayList<Invitation>) invitationList;
	}

	/**
	 * @return the listOfId
	 */
	public int[] getListOfId() {
		return listOfId;
	}

	/**
	 * @param listOfId the listOfId to set
	 */
	public void setListOfId(int[] listOfId) {
		this.listOfId = listOfId;
	}

	/**
	 * @return the fridgeId
	 */
	public int getFridgeId() {
		return fridgeId;
	}

	/**
	 * @param fridgeId the fridgeId to set
	 */
	public void setFridgeId(int fridgeId) {
		this.fridgeId = fridgeId;
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
}
