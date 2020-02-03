package logic.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.bean.BeanChooseRecipes;
import logic.controller.ChooseRecipesController;
import logic.implementation.exceptions.EmptyException;

public class ChooseRecipesUI {
	private ArrayList<String> images;
	private ArrayList<String> titles;
	private ArrayList<ArrayList<String>> contents;
	private ArrayList<String> listFood;
	
	public ChooseRecipesUI() {
		this.images = new ArrayList<>();
		this.titles = new ArrayList<>();
		this.contents = new ArrayList<>();
	}
	
	public void initListFood(){ 
		try {
			BeanChooseRecipes beanChooseRecipes = ChooseRecipesController.takeFood();
			this.listFood = (ArrayList<String>) beanChooseRecipes.getListFood();				

		}catch( EmptyException ee ) {
			// creo un Logger 
	        Logger logger = Logger.getLogger( 
	        		ChooseRecipesUI.class.getName()); 
	        logger.log(Level.WARNING, "empty food list");
		 }
			
	}
	
	public void clickedOnStartSearch( List<String> listEliminatedIngredients , int numRecipes ) {
		
		BeanChooseRecipes beanChooseRecipes = new BeanChooseRecipes();
		beanChooseRecipes.setListFood( (ArrayList<String>) listEliminatedIngredients);
		beanChooseRecipes.setNumRecipes(numRecipes);
		ChooseRecipesController chooseRecipesCTRL = new ChooseRecipesController();		
		beanChooseRecipes = chooseRecipesCTRL.startSearch(beanChooseRecipes);
		//passare la lista di ricette al controllerFXML
		
		ArrayList<String> listImages = new ArrayList<>();
		ArrayList<String> listTitle = new ArrayList<>();
		ArrayList<ArrayList<String>> listContents = new ArrayList<>();
		
		for( int i = 0; i< beanChooseRecipes.getListRecipe().size(); i++ ) {
			listImages.add(beanChooseRecipes.getListRecipe().get(i).getLink());
			listTitle.add(beanChooseRecipes.getListRecipe().get(i).getTitle());
			listContents.add((ArrayList<String>) beanChooseRecipes.getListRecipe().get(i).getContent());
		}
		this.images = listImages;
		this.titles = listTitle;
		this.contents = listContents;

	}
	

	
	public List<String> getListFood(){
		return this.listFood;
	}

	/**
	 * @return the contents
	 */
	public List<ArrayList<String>> getContents() {
		return contents;
	}



	/**
	 * @return the titles
	 */
	public List<String> getTitles() {
		return titles;
	}


	/**
	 * @return the images
	 */
	public List<String> getImages() {
		return images;
	}

}