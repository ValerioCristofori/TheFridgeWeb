package logic.implementation;

import logic.implementation.gof.SingletonInstances;

public class AdminCheck {
	
	public boolean checkAdminUI() {
		return SingletonInstances.getSingletonInstance().getCurrentUser().isAdmin();
	}
}
