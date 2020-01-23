package logic.controller;

import logic.bean.BeanAddFood;
import logic.dao.DaoFood;
import logic.entity.Food;
import logic.implementation.ListAllFood;
import logic.implementation.gof.SingletonInstances;

public class AddFoodController {
	
	
	public AddFoodController() {
		SingletonInstances.getSingletonInstance();
	}
	
	public void insertFood( BeanAddFood beanAddFood ) {
		Food food = new Food();
		food.setName(beanAddFood.getName());
		food.setQuantity(beanAddFood.getQuantity());
		food.setExpirationDate(beanAddFood.getExpirationDate());		
		DaoFood daoFood = new DaoFood();
		daoFood.saveFood( food, SingletonInstances.getSingletonInstance().getCurrentFridge());
	}
	
	public boolean validSemanticName( String name ) {		
		for( String string : ListAllFood.getListAllFood() ) {
			if( name.equals(string) ) return true;
		}
		return false;
	}
	
}
