package logic.boundary;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import logic.bean.BeanRecipesWebsite;




public class RecipesWebsiteUI {
	

	
	

	
	
	public RecipesWebsiteUI() {
		
	}
		

	
	public BeanRecipesWebsite searchRecipe(BeanRecipesWebsite beanRecipesWebsite) throws IOException, InterruptedException, UnirestException {
			
		ArrayList<String> ingredients = (ArrayList<String>) beanRecipesWebsite.getRecipe().getListFoodName();
		String string = "";
		for( String name : ingredients ) {
			string = string + name + ",";
		}
		
		HttpResponse<JsonNode> request = Unirest.get( String.format( "https://api.spoonacular.com/recipes/findByIngredients?number=1&ranking=1&ignorePantry=false&ingredients=%s", string ) )
			      .header("accept", "application/json")
			      .queryString("apiKey", "182a4ed3fcac422bb77989c8be661be3")
			      .asJson();
		
		
		JSONObject jo = request.getBody().getArray().getJSONObject(0);
		JSONArray jaUsed = (JSONArray) jo.get("usedIngredients");
		JSONArray jaMissed = (JSONArray) jo.get("missedIngredients");
		
		
		String responseJSONString = jo.toString();
		System.out.println();
		
		System.out.println(responseJSONString);	      
        
        
        ArrayList<String> content = new ArrayList<>();
        // setting content
        
        for( int i = 0; i< jaUsed.length(); i++) {
        	System.out.println(i);
        	JSONObject joUsed = jaUsed.getJSONObject(i);
        	content.add( (String) joUsed.get("original"));
        	
        }
        
        for( int i = 0; i< jaMissed.length(); i++) {
        	System.out.println(i);
        	JSONObject joMissed = jaMissed.getJSONObject(i);
        	content.add( (String) joMissed.get("original"));
        	
        }
        for( int i = 0; i< content.size(); i++) {
        	System.out.println(content.get(i));
        	
        }
        
		String title = (String) request.getBody().getArray().getJSONObject(0).get("title");
        System.out.println(title);
        
        
        String recipeImage = (String) request.getBody().getArray().getJSONObject(0).get("image");
        System.out.println(recipeImage);
		
		beanRecipesWebsite.getRecipe().setLink(recipeImage);
		beanRecipesWebsite.getRecipe().setContent(content);
		beanRecipesWebsite.getRecipe().setTitle(title);
		return beanRecipesWebsite;	
		
			
		
	}
	
	
}