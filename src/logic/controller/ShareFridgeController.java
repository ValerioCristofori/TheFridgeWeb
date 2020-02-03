package logic.controller;

import logic.bean.BeanShareFridge;
import logic.dao.DaoInvitation;
import logic.entity.Invitation;
import logic.implementation.gof.FacadeCheckUsername;
import logic.implementation.gof.SingletonInstances;


public class ShareFridgeController {
	
	public boolean isValidUsername( String username ) {
		if( username == SingletonInstances.getSingletonInstance().getCurrentUser().getUsername() ) return false;
		FacadeCheckUsername check = new FacadeCheckUsername();
		return check.usernameExist(username);
	}
	
	public boolean isValidEmail( String email ) {
		if( email == SingletonInstances.getSingletonInstance().getCurrentUser().getEmailAddress()) return false;
		FacadeCheckUsername check = new FacadeCheckUsername();
		if( check.emailExist(email)) {
			return true;
		}
		return false;
		
	}
	
	public void inviteWithUsername( BeanShareFridge beanShareFridge ) {
		beanShareFridge.setInvitingUsername( SingletonInstances.getSingletonInstance().getCurrentUser().getUsername() );
		
		Invitation invitation = new Invitation();		
		invitation.setInvitedUser( beanShareFridge.getInvitedUsername() );
		invitation.setInvitingUser(beanShareFridge.getInvitingUsername());
		invitation.setMessage(beanShareFridge.getMessage());
		
		DaoInvitation daoInvitation = new DaoInvitation();
		daoInvitation.sendInvitationDB( invitation );
	}
		
	public void inviteWithEmail( BeanShareFridge beanShareFridge ) {
		beanShareFridge.setInvitingUsername( SingletonInstances.getSingletonInstance().getCurrentUser().getUsername() );
		
		
		Invitation invitation = new Invitation();		
		invitation.setInvitedEmail( beanShareFridge.getInvitedEmail() );
		invitation.setInvitingUser(beanShareFridge.getInvitingUsername());
		invitation.setMessage(beanShareFridge.getMessage());
		
		DaoInvitation daoInvitation = new DaoInvitation();
		daoInvitation.sendInvitationDBEmail( invitation );
	}
	
}
