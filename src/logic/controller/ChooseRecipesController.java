package logic.controller;

import java.util.ArrayList;

import logic.bean.BeanChooseRecipes;
import logic.bean.BeanViewFridge;
import logic.implementation.exceptions.EmptyException;


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
	
	/*
	
	public BeanChooseRecipes startSearch( BeanChooseRecipes beanChooseRecipes ) {
		ArrayList<String> listEliminatedIngredients = (ArrayList<String>) beanChooseRecipes.getListFood();
		int numRecipes = beanChooseRecipes.getNumRecipes();
		int c;
		ArrayList<String> listIngredients = new ArrayList<>(); 
		ArrayList<Recipe> recipeList = new ArrayList<>(numRecipes); 
		
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
		
		// inizia il caso d'uso
		
		
		// for testing
		
		for( int i = 0; i < numRecipes ; i++ ) {
			ArrayList<String> ingredients = new ArrayList<>(3);
			
			// prendo tre food a caso nella lista degli alimenti che non siano presenti nella lista degli eliminati
			
			for( c = 0; c < 3; c++ ) {
				 Random random = new Random(); 
				 int index = random.nextInt(listIngredients.size());
			     String foodName = listIngredients.get(index);
				 ingredients.add(foodName);
			}
			//chiamo funzione che usando selenium va sul sito di ricette e riempie i campi con i tre food presi
			
			
			String link = this.searchRecipeLink(ingredients);
			
			Recipe recipe = new Recipe();
			recipe.setLink(link);
			recipe.setListFoodName(ingredients);
			recipeList.add(recipe);
			
			// ad ogni passo aggiungo il link trovato a un array di link per poi ritornarlo a ciclo concluso 
			
		}
		beanChooseRecipes.setListRecipe(recipeList);
		return beanChooseRecipes;
	}
	
	private String searchRecipeLink( ArrayList<String> arg ) {
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.giallozafferano.it/");
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div/button")).click();
		for( String foodName : arg ) {
			driver.findElement(By.xpath("//*[@id=\"gz-header-search-input\"]")).sendKeys(String.format( "%s ", foodName ) );
		}
		driver.findElement(By.xpath("//*[@id=\"gz-header-search-submit\"]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/main/div/div/article[1]/div[1]/a/picture/img")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// prendere l'url dell'ultima pagina
		String link = driver.getCurrentUrl();
		driver.close();
		return link;
		
	}
	*/
	
}
