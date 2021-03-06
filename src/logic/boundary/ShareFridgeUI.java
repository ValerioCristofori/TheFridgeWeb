package logic.boundary;

import logic.bean.BeanShareFridge;
import logic.controller.ShareFridgeController;

public class ShareFridgeUI {
	
	
	public boolean isValidUsername( String username ) {
		// controlli sintattici eventuali	
		ShareFridgeController shareFridgeCTRL = new ShareFridgeController();
		if( username.equals( shareFridgeCTRL.takeUsername()) ) {
			return false;
		}
		
		return shareFridgeCTRL.isValidUsername(username);
	}
	
	public boolean isValidEmail( String email ) {
		// controlli sintattici eventuali	
		// validate email ---> diversa da quella dell invitante
		ShareFridgeController shareFridgeCTRL = new ShareFridgeController();
		return shareFridgeCTRL.isValidEmail(email);
		
	}
	
	
	public void clickedOnInviteWithUsername( String username , String message ) {
		//controllo massimo 100 caratteri	
		
		BeanShareFridge beanShareFridge = new BeanShareFridge();
		beanShareFridge.setInvitedUsername( username );
		beanShareFridge.setMessage( message );
		ShareFridgeController shareFridgeCTRL = new ShareFridgeController();
		shareFridgeCTRL.inviteWithUsername(beanShareFridge);
		
	}
	
	
	public void clickedOnInviteWithEmail( String email, String message ) {
		//controllo massimo 100 caratteri	
		
		BeanShareFridge beanShareFridge = new BeanShareFridge();
		beanShareFridge.setInvitedEmail( email );
		beanShareFridge.setMessage( message );
		ShareFridgeController shareFridgeCTRL = new ShareFridgeController();
		shareFridgeCTRL.inviteWithEmail(beanShareFridge);
		
	}
	
}
