package logic.controller;

import logic.bean.BeanAddFood;
import logic.bean.BeanViewFridge;
import logic.dao.DaoFood;
import logic.entity.Food;
import logic.implementation.ListAllFood;
import logic.implementation.exceptions.DuplicatedFoodException;
import logic.implementation.gof.SingletonInstances;

public class AddFoodController {
	
	
	public AddFoodController() {
		SingletonInstances.getSingletonInstance();
	}
	
	public void insertFood( BeanAddFood beanAddFood ) {
		Food food = new Food();
		food.setName(beanAddFood.getNameFood());
		food.setQuantity(beanAddFood.getQuantityFood());
		food.setExpirationDate(beanAddFood.getExpirationDateFood());		
		DaoFood daoFood = new DaoFood();
		try {
			daoFood.saveFood( food, SingletonInstances.getSingletonInstance().getCurrentFridge());
		} catch (DuplicatedFoodException e) {
			int quantityFood = e.getQuantityDuplicated();
			String nameFood = e.getNameDuplicated();
			food.setName(nameFood);
			food.setQuantity(quantityFood + beanAddFood.getQuantityFood());
			BeanViewFridge beanViewFridge = new BeanViewFridge();
			beanViewFridge.setFoodName(nameFood);
			beanViewFridge.setFoodQuantity(quantityFood);
			ViewFridgeController viewFridgeController = new ViewFridgeController();
			viewFridgeController.removeFood(beanViewFridge);
			
			
			daoFood.saveSafelyFood( food, SingletonInstances.getSingletonInstance().getCurrentFridge());
			
		}
	}
	
	public boolean validSemanticName( String name ) {		
		for( String string : ListAllFood.getListAllFood() ) {
			if( name.equals(string) ) return true;
		}
		return false;
	}
	
}
