package logic.implementation.gof;

import logic.controller.LoginController;
import logic.controller.RegistrationController;
import logic.implementation.ValidateCredentialsInterface;

public class FactorySign {
	
	public ValidateCredentialsInterface createSignCTRL( int type ) {
		if( type == 1 ) {
			return new LoginController();
		}else if( type == 2 ) {
			return new RegistrationController();
		}else {
			return null;
		}
		
	}
	
}
