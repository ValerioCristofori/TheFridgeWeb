package logic.implementation.gof;

import logic.dao.DaoFridge;
import logic.dao.DaoUser;
import logic.entity.Admin;
import logic.entity.Fridge;
import logic.entity.User;

public class SingletonInstances {
	private static SingletonInstances instance = null;
	private Fridge myFridge;
	private Fridge currentFridge;
	private User currentUser;
	
	private SingletonInstances() {		
	}
	
	public void takeFridgeInstance() {
		DaoUser daoUser = new DaoUser();
		this.myFridge = daoUser.getFridgeOfUser( this.currentUser );
		this.currentFridge = this.myFridge;
	}
	
	public void takeFridgeById( int id ) {
		DaoFridge daoFridge = new DaoFridge();
		currentFridge = daoFridge.getFridgeById( id );
	}
	
	public void becomeUser() {
		//become user
		User user = new User();
		user.setUsername( currentUser.getUsername() );
		user.setPassword( currentUser.getPassword() );
		user.setEmailAddress( currentUser.getEmailAddress() );
		currentUser = user;		
	}
	
	public void becomeAdmin() {
		//become user
		User admin = new Admin();
		admin.setUsername( currentUser.getUsername() );
		admin.setPassword( currentUser.getPassword() );
		admin.setEmailAddress( currentUser.getEmailAddress() );
		currentUser = admin;	
	}

	/**
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return this.currentUser;
	}

	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * @return the currentFridge
	 */
	public Fridge getCurrentFridge() {
		
		return this.currentFridge;
	}
	
	/**
	 * @return the myFridge
	 */
	public Fridge getMyFridge() {
		
		return this.myFridge;
	}
	
	/**
	 * @param currentFridge the currentFridge to set
	 */
	public void setMyFridge(Fridge myFridge) {
		this.myFridge = myFridge;
	}


	/**
	 * @param currentFridge the currentFridge to set
	 */
	public void setCurrentFridge(Fridge currentFridge) {
		this.currentFridge = currentFridge;
	}

	
	
	public static synchronized SingletonInstances getSingletonInstance() {
		if( SingletonInstances.instance == null ) {
			SingletonInstances.instance = new  SingletonInstances();
		}
		return instance;
	}
}
