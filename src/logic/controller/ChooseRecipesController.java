package logic.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.json.JSONException;

import logic.bean.BeanChooseRecipes;
import logic.bean.BeanRecipesWebsite;
import logic.bean.BeanViewFridge;
import logic.boundary.RecipesWebsiteUI;
import logic.entity.Recipe;
import logic.implementation.ListAllFood;
import logic.implementation.exceptions.EmptyException;
import logic.implementation.exceptions.LessThan3IngredientsException;


public class ChooseRecipesController {
	//levare lista mettere fridge con lista nella SingletonInstances
	private static ArrayList<String> list;

	 
	public static BeanChooseRecipes takeFood() throws EmptyException {
		ViewFridgeController viewFridgeCTRL = new ViewFridgeController();
		BeanViewFridge beanViewFridge = viewFridgeCTRL.takeContent();
		list = new ArrayList<>( beanViewFridge.getListOfFood().size() );
		for( int i=0; i< beanViewFridge.getListOfFood().size() ; i++ ) {
			String name = beanViewFridge.getListOfFood().get(i).getName();
			list.add( i, name );			
		}
		BeanChooseRecipes beanChooseRecipes = new BeanChooseRecipes();
		beanChooseRecipes.setListFood(list);
		return beanChooseRecipes;				
	}  
	
	
	public BeanChooseRecipes startSearch( BeanChooseRecipes beanChooseRecipes ) {
		ArrayList<String> listEliminatedIngredients = (ArrayList<String>) beanChooseRecipes.getListFood();
		int numRecipes = beanChooseRecipes.getNumRecipes();
		int numIngredients = 3;
		ArrayList<String> listIngredients = new ArrayList<>(); 
		
		
		// creare effettiva lista ingredienti
		if(listEliminatedIngredients != null ) {
			for( String food : list ) {
				if( !listEliminatedIngredients.contains(food)) {
					listIngredients.add(food);
				}
			}
		}else {
			listIngredients = list;
		}
		
		BeanChooseRecipes beanRecipes = new BeanChooseRecipes();
		ArrayList<Recipe> recipes = new ArrayList<>();
		beanRecipes.setListRecipe(recipes);
		
		for( int i = 0 ; i < numRecipes ; i++ ) {
			
			ArrayList<String> ingredients = new ArrayList<>(3);
			Random random = new Random(); 
			for( int j=0; j< numIngredients; j++ ) {
				int index = random.nextInt(listIngredients.size());
				String foodName = listIngredients.get(index);
				if( !ingredients.contains( foodName ) ){
					ingredients.add(foodName);
				}
				
				
			}
			
				
			//aggiungo ricetta
			beanRecipes.getListRecipe().add( this.search(ingredients));
			
			
		}
		
		return beanRecipes;
		
		
		
	}
	
	private Recipe search( ArrayList<String> ingredients ) {
		BeanRecipesWebsite beanRecipesWebsite = new BeanRecipesWebsite();
		Recipe recipe = new Recipe();
		recipe.setListFoodName(ingredients);
		beanRecipesWebsite.setRecipe( recipe );
		
		RecipesWebsiteUI recipesWebSiteUI = new RecipesWebsiteUI();
		try {
			beanRecipesWebsite = recipesWebSiteUI.searchRecipe(beanRecipesWebsite);
		} catch (IOException | InterruptedException | JSONException  e) {

			e.printStackTrace();
		}catch( LessThan3IngredientsException e ) {
			ArrayList<String> generatedIngredients = (ArrayList<String>) e.getIngredients();
			Random ran = new Random(); 
			while( generatedIngredients.size() < 3 ) {
				int index = ran.nextInt(ListAllFood.getListAllFood().length);
				String foodName = ListAllFood.getListAllFood()[index];
				if( !generatedIngredients.contains( foodName ) ){
					generatedIngredients.add(foodName);
				}
				
			}
			return this.search(generatedIngredients);
			
			
			
		}
		return beanRecipesWebsite.getRecipe();
	}

}