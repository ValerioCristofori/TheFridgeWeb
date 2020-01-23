package logic.implementation;

import logic.implementation.gof.SingletonInstances;

public class UserUI {
	
	public boolean checkAdminUI() {
		return SingletonInstances.getSingletonInstance().getCurrentUser().isAdmin();
	}
}
