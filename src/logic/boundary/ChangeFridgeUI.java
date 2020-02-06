package logic.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.bean.BeanChangeFridge;
import logic.controller.ChangeFridgeController;
import logic.implementation.exceptions.EmptyException;
import logic.implementation.exceptions.EmptyInvitationException;
import logic.implementation.exceptions.TooManyFridgesException;

public class ChangeFridgeUI {
	private int[] listId;
	private ArrayList<String> invitingUsers;
	private ArrayList<String> messages;
	
	public ChangeFridgeUI() {
		this.invitingUsers = new ArrayList<>();
		this.messages = new ArrayList<>();
	}
	
	public void clickedOnDeleteAccount() {
		ChangeFridgeController changeFridgeCTRL = new ChangeFridgeController();
		changeFridgeCTRL.deleteAccount();		
	}
	
	public void takeInvitations() throws EmptyInvitationException {
		
		ChangeFridgeController changeFridgeCTRL = new ChangeFridgeController();
		BeanChangeFridge beanChangeFridge = changeFridgeCTRL.takeInvitations();
		for( int i = 0; i < beanChangeFridge.getInvitationList().size(); i++ ) {
			this.invitingUsers.add( beanChangeFridge.getInvitationList().get(i).getInvitingUser() );
			this.messages.add( beanChangeFridge.getInvitationList().get(i).getMessage());
		}
			
	} 
	
	public void clickedOnDeclineInvitation( String selectedUser ) {
		BeanChangeFridge beanChangeFridge = new BeanChangeFridge();
		beanChangeFridge.setInvitingUser(selectedUser);
		ChangeFridgeController changeFridgeCTRL = new ChangeFridgeController();
		changeFridgeCTRL.deleteInvitation(beanChangeFridge);
	}
	
	public void clickedOnAcceptInvitation( String selectedUser ) throws TooManyFridgesException {
		BeanChangeFridge beanChangeFridge = new BeanChangeFridge();
		beanChangeFridge.setInvitingUser(selectedUser);
		ChangeFridgeController changeFridgeCTRL = new ChangeFridgeController();
		changeFridgeCTRL.acceptInvitation(beanChangeFridge);
	}
	
	public List<String> startFridgesInterfaces(){
		try {
			ChangeFridgeController changeFridgeCTRL = new ChangeFridgeController();
			BeanChangeFridge beanChangeFridge = changeFridgeCTRL.takeMyFridges();
			listId = beanChangeFridge.getListOfId();
			return (ArrayList<String>) beanChangeFridge.getListOfNameFridges();
		}catch(EmptyException ee ) {
			// creo un Logger 
	        Logger logger = Logger.getLogger( 
	        		ChangeFridgeUI.class.getName()); 
	        logger.log(Level.WARNING, "empty fridge list");
		}
		return new ArrayList<>();			
	}
	
	public void clickedOnChangeFridge( int index ) {
		BeanChangeFridge beanChangeFridge = new BeanChangeFridge();
		beanChangeFridge.setFridgeId( listId[index] );
		ChangeFridgeController changeFridgeCTRL = new ChangeFridgeController();
		changeFridgeCTRL.changeFridge(beanChangeFridge);
	}
	
	public void clickedOnChangeInMyFridge() {
		ChangeFridgeController changeFridgeCTRL = new ChangeFridgeController();
		changeFridgeCTRL.changeInMyFridge();
	}
	
	
	public List<String> getInvitingUsers(){
		return this.invitingUsers;
	}
	
	public List<String> getMessages(){
		return this.messages;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		ChangeFridgeController changeFridgeController = new ChangeFridgeController();
		return changeFridgeController.takeEmail();
		
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		ChangeFridgeController changeFridgeController = new ChangeFridgeController();
		return changeFridgeController.takeUsername();
		
	}

	/**
	 * @return the myFridgeName
	 */
	public String getMyFridgeName() {
		ChangeFridgeController changeFridgeController = new ChangeFridgeController();
		return changeFridgeController.takeMyFridgeName();
		
	}

}
