package logic.boundary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import logic.bean.BeanCredentials;
import logic.controller.RegistrationController;
import logic.implementation.Credentials;

public class RegistrationUI extends Credentials {
	private String username;
	private String password;
	private String emailAddress;
	
	public void clickedOnRegistration( String username, String emailAddress, String password ){
		BeanCredentials beanC = new BeanCredentials();
		beanC.setUsernameBean(username);
		beanC.setEmailAddressBean(emailAddress);
		beanC.setPasswordBean(password);
		RegistrationController registrationCTRL = new RegistrationController();
		registrationCTRL.registration( beanC );
	}  
	
	
	public boolean notExist(String name, String email, String pass) {
		this.username = name;
		this.password = pass;
		this.emailAddress = email;
		return super.notExist(this.username, this.emailAddress, this.password);
	}
	
	public boolean validSyntaxUsername( String username ) {
		if (username == null){
			return false;
		}
		return !( username.length() < 4 || username.length() > 30 );
	}
	
	public boolean validSyntaxPassword( String password ) {
		if (password == null){
			return false;
		}
		return !( password.length() < 6 || password.length() > 30 );
	}
	
	public boolean validSyntaxEmail( String mail ) {
		if (mail == null){
			return false;
		}

		Pattern p = Pattern.compile(".+@.+\\.[a-z]+", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(mail);
		boolean matchFound = m.matches();

		//Condizioni più restrittive rispetto alle precedenti
		String  expressionPlus="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		Pattern pPlus = Pattern.compile(expressionPlus, Pattern.CASE_INSENSITIVE);
		Matcher mPlus = pPlus.matcher(mail);
		boolean matchFoundPlus = mPlus.matches();
		         
		return matchFound && matchFoundPlus;   
	}
}
