package logic.implementation;

import logic.bean.BeanCredentials;
import logic.implementation.gof.FactorySign;

public class Credentials {
	
	
	public boolean isValid(String username, String password) {
		//controlli semantico
		BeanCredentials beanC = new BeanCredentials();
		beanC.setUsername(username);
		beanC.setPassword(password);		
		FactorySign signFactory = new FactorySign();
		ValidateCredentialsInterface loginCTRL = signFactory.createSignCTRL(1);		
		return loginCTRL.checkValid(beanC);
	}
	
	public boolean notExist(String username, String emailAddress, String password) {
		//controlli semantico
		BeanCredentials beanC = new BeanCredentials();
		beanC.setUsername(username);
		beanC.setEmailAddress(emailAddress);
		beanC.setPassword(password);
		FactorySign signFactory = new FactorySign();
		ValidateCredentialsInterface registrationCTRL = signFactory.createSignCTRL(2);
		return registrationCTRL.checkValid(beanC) ;
	}
	
}
