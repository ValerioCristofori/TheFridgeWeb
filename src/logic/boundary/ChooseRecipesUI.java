package logic.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.BeanChooseRecipes;
import logic.controller.ChooseRecipesController;
import logic.implementation.exceptions.EmptyException;

public class ChooseRecipesUI {
	private ArrayList<String> links;
	private ArrayList<String> ingredients;
	
	public ChooseRecipesUI() {
		this.links = new ArrayList<>();
		this.ingredients = new ArrayList<>();
	}
	
	public ObservableList<String> getListFood(){
		try {
			BeanChooseRecipes beanChooseRecipes = ChooseRecipesController.takeFood();
			ArrayList<String> list = (ArrayList<String>) beanChooseRecipes.getListFood();
			
			return FXCollections.observableArrayList( list );				

		}catch( EmptyException ee ) {
			// creo un Logger 
	        Logger logger = Logger.getLogger( 
	        		ChooseRecipesUI.class.getName()); 
	        logger.log(Level.WARNING, "empty food list");
		 }
			return null;
	}
	
	public void clickedOnStartSearch( List<String> listEliminatedIngredients , int numRecipes ) {
		/*
		BeanChooseRecipes beanChooseRecipes = new BeanChooseRecipes();
		beanChooseRecipes.setListFood( listEliminatedIngredients);
		beanChooseRecipes.setNumRecipes(numRecipes);
		ChooseRecipesController chooseRecipesCTRL = new ChooseRecipesController();		
		beanChooseRecipes = chooseRecipesCTRL.startSearch(beanChooseRecipes);
		//passare la lista di ricette al controllerFXML
		for( int i = 0; i< beanChooseRecipes.getListRecipe().size(); i++ ) {
			this.links.add(beanChooseRecipes.getListRecipe().get(i).getLink());
			this.ingredients.add(beanChooseRecipes.getListRecipe().get(i).getListFoodName().get(0));
			this.ingredients.add(beanChooseRecipes.getListRecipe().get(i).getListFoodName().get(1));
			this.ingredients.add(beanChooseRecipes.getListRecipe().get(i).getListFoodName().get(2));
		}
		*/
	}
	
	
	
	public List<String> getLinks(){
		return this.links;
	}
	
	public List<String> getIngredients(){
		return this.ingredients;
	}
}
