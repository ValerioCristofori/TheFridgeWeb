package logic.controller;

import java.util.ArrayList;

import logic.bean.BeanViewFridge;
import logic.dao.DaoFood;
import logic.dao.DaoFridge;
import logic.dao.DaoUser;
import logic.entity.Food;
import logic.entity.Fridge;
import logic.entity.User;
import logic.implementation.AdminCheck;
import logic.implementation.exceptions.EmptyException;
import logic.implementation.gof.SingletonInstances;

public class ViewFridgeController {
	
	public ViewFridgeController() {
		SingletonInstances.getSingletonInstance();
	}
	
	public BeanViewFridge takeContent() throws EmptyException {
		DaoFridge daoFridge = new DaoFridge();
		Fridge fridge = SingletonInstances.getSingletonInstance().getCurrentFridge();
		fridge.setListOfFood( (ArrayList<Food>) daoFridge.getContentFridge(fridge) );
		//set fridge in SingletonInstances
		SingletonInstances.getSingletonInstance().setCurrentFridge(fridge);
		//riempire la bean dei dati 
		BeanViewFridge beanViewFridge = new BeanViewFridge();
		beanViewFridge.setId(fridge.getId());
		beanViewFridge.setName(fridge.getName());
		beanViewFridge.setListOfFood(fridge.getListOfFood());
		return beanViewFridge; 
		//mandarli alla boundary
	} 

	public void changeFridgeName( String name ) {
		DaoUser daoUser = new DaoUser();
		DaoFridge daoFridge = new DaoFridge();
		User user = new User();
		user.setUsername(SingletonInstances.getSingletonInstance().getCurrentUser().getUsername());
		Fridge fridge = daoUser.getFridgeOfUser(user);
		fridge.setName(name);
		AdminCheck adminCheck = new AdminCheck();
		if( adminCheck.checkAdminUI()) {
			SingletonInstances.getSingletonInstance().setMyFridge(fridge);
		}		
		SingletonInstances.getSingletonInstance().setCurrentFridge(fridge);
		daoFridge.updateFridgeNameInDB( fridge );
	}
	
	
	public void removeFood ( BeanViewFridge beanViewFridge ) {
		Food food = new Food();
		food.setName(beanViewFridge.getFoodName());
		food.setQuantity(beanViewFridge.getFoodQuantity());
		int id = SingletonInstances.getSingletonInstance().getCurrentFridge().getId();
		DaoFood daoFood = new DaoFood();
		daoFood.removeFood(food, id);	
		
	}
	
	public String takeFridgeName() {
		return SingletonInstances.getSingletonInstance().getCurrentFridge().getName();
	}
}
