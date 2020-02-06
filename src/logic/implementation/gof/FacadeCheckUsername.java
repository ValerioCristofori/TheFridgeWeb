package logic.implementation.gof;

import logic.dao.DaoUser;
import logic.entity.User;

public class FacadeCheckUsername {
	
	public boolean usernameExist( String username ) {
		User user = new User();
		user.setUsername(username);
		DaoUser daoUser = new DaoUser();
		return daoUser.checkValidUsername(user);
	}
	
	public boolean matchUserPass( String username, String password ) {
		User user = new User();
		user.setUsername(username);
		DaoUser daoUser = new DaoUser();
		return password.equals( daoUser.takePassword(user));
	}
	
	public boolean emailExist( String email) {
		User user = new User();
		user.setEmailAddress(email);
		DaoUser daoUser = new DaoUser();
		return daoUser.checkValidEmail(user);
	}
}
