package logic.controller;

import java.util.ArrayList;

import logic.bean.BeanChangeFridge;
import logic.dao.DaoInvitation;
import logic.dao.DaoUser;
import logic.entity.Fridge;
import logic.entity.Invitation;
import logic.entity.User;
import logic.implementation.exceptions.EmptyException;
import logic.implementation.exceptions.TooManyFridgesException;
import logic.implementation.gof.SingletonInstances;

public class ChangeFridgeController {
	
	
	public void deleteAccount() {
		String username = SingletonInstances.getSingletonInstance().getCurrentUser().getUsername();
		User user = new User();
		user.setUsername(username);
		DaoUser daoUser = new DaoUser();
		daoUser.deleteUser( user );
	}
	
	public BeanChangeFridge takeInvitations() throws EmptyException {
		String username = SingletonInstances.getSingletonInstance().getCurrentUser().getUsername();
		DaoInvitation daoInvitation = new DaoInvitation();
		ArrayList<Invitation> invitationList = (ArrayList<Invitation>) daoInvitation.takeInvitationsFromDB( username );
		BeanChangeFridge beanChangeFridge = new BeanChangeFridge();
		beanChangeFridge.setInvitationList(invitationList);
		return beanChangeFridge;
	}
	
	public void deleteInvitation( BeanChangeFridge beanChangeFridge ) {
		
		String invitingUser = beanChangeFridge.getInvitingUser();
		Invitation declineInvitation = new Invitation();
		declineInvitation.setInvitingUser(invitingUser);
		declineInvitation.setInvitedUser( SingletonInstances.getSingletonInstance().getCurrentUser().getUsername());
		DaoInvitation daoInvitation = new DaoInvitation();
		daoInvitation.deleteInvitationFromDB( declineInvitation );
	}
	
	public void acceptInvitation( BeanChangeFridge beanChangeFridge ) throws TooManyFridgesException {
		DaoUser daoUser = new DaoUser();
		User invitedUser = new User();
		invitedUser.setUsername(SingletonInstances.getSingletonInstance().getCurrentUser().getUsername());
		int c = daoUser.countMembership(invitedUser);
		if( c < 4 ) {			
			Invitation invitation = new Invitation();
			String invitingUser = beanChangeFridge.getInvitingUser();
			invitation.setInvitingUser( invitingUser );
			invitation.setInvitedUser( SingletonInstances.getSingletonInstance().getCurrentUser().getUsername());
			
			// loop: per ogni invito divento user del frigo dell'utente che mi ha invitato ----> aggiungo il frigo in change fridge dell'utente invitato
			User user = new User();
			user.setUsername(invitingUser);
			Fridge fridge = daoUser.getFridgeOfUser(user);
			DaoInvitation daoInvitation = new DaoInvitation();
			daoInvitation.startMembership( invitation , fridge );
			daoInvitation.deleteInvitationFromDB( invitation );
		} 
		else {
			throw new TooManyFridgesException("too many fridges");
		}
	}
	
	public BeanChangeFridge takeMyFridges() throws EmptyException {
		User user = new User();
		user.setUsername(SingletonInstances.getSingletonInstance().getCurrentUser().getUsername() );
		DaoUser daoUser = new DaoUser();
		ArrayList<Fridge> listOfFridges = (ArrayList<Fridge>) daoUser.takeFridgesFromDB(user);
		ArrayList<String> listOfNameFridges = new ArrayList<>( listOfFridges.size() );
		int[] listOfId = new int[listOfFridges.size()];
		for( int i=0; i< listOfFridges.size() ; i++ ) {	
			listOfNameFridges.add( i, listOfFridges.get(i).getName() );	
			listOfId[i] = listOfFridges.get(i).getId();
		}
		BeanChangeFridge beanChangeFridge = new BeanChangeFridge();
		beanChangeFridge.setListOfNameFridges(listOfNameFridges);
		beanChangeFridge.setListOfId(listOfId);
		return beanChangeFridge;
		
	}
	
	public void changeFridge( BeanChangeFridge beanChangeFridge ) {
		int fridgeId = beanChangeFridge.getFridgeId();
		SingletonInstances instances = SingletonInstances.getSingletonInstance();
		instances.takeFridgeById(fridgeId);
		instances.becomeUser();
	
	}
	
	public void changeInMyFridge() {
		SingletonInstances instances = SingletonInstances.getSingletonInstance();
		if( !instances.getCurrentUser().isAdmin() ) {
			instances.setCurrentFridge(instances.getMyFridge());
			instances.becomeAdmin();
		}
	}
	
}


