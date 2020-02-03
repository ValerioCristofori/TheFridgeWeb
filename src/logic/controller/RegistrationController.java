package logic.controller;

import java.util.Random;

import logic.bean.BeanCredentials;
import logic.dao.DaoFridge;
import logic.dao.DaoUser;
import logic.entity.Admin;
import logic.entity.Fridge;
import logic.entity.User;
import logic.implementation.SaveInstances;
import logic.implementation.ValidateCredentialsInterface;
import logic.implementation.gof.FacadeCheckUsername;
import logic.implementation.gof.SingletonInstances;

public class RegistrationController implements ValidateCredentialsInterface, SaveInstances{

	
	public void registration( BeanCredentials beanC ) {
		User admin = new Admin();
		admin.setUsername(beanC.getUsernameBean());
		admin.setEmailAddress(beanC.getEmailAddressBean());
		admin.setPassword(beanC.getPasswordBean());	
		
		DaoUser daoUser = new DaoUser();
		daoUser.saveRegistrationToDB(admin);
		
		DaoFridge daoFridge = new DaoFridge();
		Fridge fridge = new Fridge();
		this.setDefaultFridge( fridge );
		daoFridge.createFridge( fridge );
		daoFridge.createAdministration( fridge, admin );
		this.save(admin, fridge);

	}
	
	@Override
	public void save( User admin, Fridge fridge ) {
		SingletonInstances instances = SingletonInstances.getSingletonInstance();
		instances.setCurrentUser(admin);
		instances.becomeAdmin();
		instances.setCurrentFridge(fridge);
		instances.setMyFridge(fridge);
	}
	
	@Override
	public boolean checkValid( BeanCredentials beanC ) {
		FacadeCheckUsername check = new FacadeCheckUsername();
		return !( check.usernameExist(beanC.getUsernameBean()));
	}
	
	private void setDefaultFridge( Fridge fridge ) {
		DaoFridge daoFridge = new DaoFridge();
		fridge.setName("fridge");
		fridge.setListOfFood(null);
		while(true) {
			Random r = new Random();
			int rand = r.nextInt(10000); 
			fridge.setId( (int) (rand));		
			
			if( daoFridge.checkFridgeID(fridge) ) {
				return;
			} 
		}
		
	}
	
	
}
