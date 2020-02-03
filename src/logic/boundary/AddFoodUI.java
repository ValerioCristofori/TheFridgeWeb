package logic.boundary;

import java.time.LocalDate;

import logic.bean.BeanAddFood;
import logic.controller.AddFoodController;

public class AddFoodUI {
	
	public void clickOnInsertFood( String name, int quantity, LocalDate expirationDate) {
		BeanAddFood beanAddFood = new BeanAddFood();
		beanAddFood.setNameFood(name);
		beanAddFood.setQuantityFood(quantity);
		if( expirationDate != null ) {
			beanAddFood.setExpirationDateFood(expirationDate.toString());
		}
		AddFoodController addFoodCTRL = new AddFoodController();
		addFoodCTRL.insertFood(beanAddFood);
	}
	
	public boolean validSemanticName( String name ) {
		AddFoodController addFoodCTRL = new AddFoodController();
		return ( addFoodCTRL.validSemanticName(name) );
	}
	
	public boolean validSyntaxQuantity( int quantity ) {
		Integer value = (Integer) quantity;
		return !(value.equals(0));
	}
}
