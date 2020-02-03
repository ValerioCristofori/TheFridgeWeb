package logic.controller;

import logic.bean.BeanCredentials;
import logic.dao.DaoUser;
import logic.entity.Admin;
import logic.entity.Fridge;
import logic.entity.User;
import logic.implementation.SaveInstances;
import logic.implementation.ValidateCredentialsInterface;
import logic.implementation.gof.FacadeCheckUsername;
import logic.implementation.gof.SingletonInstances;

public class LoginController implements ValidateCredentialsInterface, SaveInstances {  
	
	@Override
	public boolean checkValid( BeanCredentials beanC ) {
		User admin = new Admin();
		admin.setUsername(beanC.getUsernameBean());
		admin.setPassword(beanC.getPasswordBean());
		FacadeCheckUsername check = new FacadeCheckUsername();
		if( !check.usernameExist(admin.getUsername()) ) return false;
		//validare se la pass e quella
		if( check.matchUserPass(admin.getUsername(), admin.getPassword()) ) {
			Fridge fridge = this.takeFridge(admin);
			admin.setEmailAddress(this.takeEmail(admin));
			this.save( admin, fridge);
			// devo prendere email e settarla in \admin/
			return true;
		}
		return false;
		
	}
	
	private String takeEmail( User user ) {
		DaoUser daoUser = new DaoUser();
		return daoUser.takeEmailFromDB(user);
	}
	
	private Fridge takeFridge( User user ) {
		DaoUser daoUser = new DaoUser();
		return daoUser.getFridgeOfUser( user );
		
	}
	
	@Override
	public void save( User user, Fridge fridge ) {
		SingletonInstances instances = SingletonInstances.getSingletonInstance();
		instances.setCurrentUser(user);
		instances.setCurrentFridge(fridge);
		instances.setMyFridge(fridge);
	}
	
	

}
