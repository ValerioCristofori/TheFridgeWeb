package logic.boundary;

import logic.bean.BeanShareFridge;
import logic.controller.ShareFridgeController;
import logic.implementation.gof.SingletonInstances;

public class ShareFridgeUI {
	
	
	public boolean isValidUsername( String username ) {
		// controlli sintattici eventuali	
		if( username.equals( SingletonInstances.getSingletonInstance().getCurrentUser().getUsername()) ) {
			return false;
		}
		ShareFridgeController shareFridgeCTRL = new ShareFridgeController();
		return shareFridgeCTRL.isValidUsername(username);
	}
	/*
	public boolean isValidEmail( String email ) {
		// controlli sintattici eventuali	
		// validate email ---> diversa da quella dell invitante
		ShareFridgeController shareFridgeCTRL = new ShareFridgeController();
		if( shareFridgeCTRL.isValidEmail(email) ) return true;
		return false;
	}
	*/
	
	public void clickedOnInviteWithUsername( String username , String message ) {
		//controllo massimo 100 caratteri	
		
		BeanShareFridge beanShareFridge = new BeanShareFridge();
		beanShareFridge.setInvitedUsername( username );
		beanShareFridge.setMessage( message );
		ShareFridgeController shareFridgeCTRL = new ShareFridgeController();
		shareFridgeCTRL.inviteWithUsername(beanShareFridge);
		
	}
	
	/*
	public void clickedOnInviteWithEmail( String email ) {
		// controlli sintattici eventuali
		
		BeanShareFridge beanShareFridge = new BeanShareFridge();
		beanShareFridge.setInvitedEmail( email );
		//ShareFridgeController.getSingletonInstance().inviteWithUsername(beanShareFridge);
		
	}
	*/
}
