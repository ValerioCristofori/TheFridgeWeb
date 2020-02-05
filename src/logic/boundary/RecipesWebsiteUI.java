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
import logic.implementation.exceptions.LessThan3IngredientsException;

public class RecipesWebsiteUI {
	private HttpResponse<JsonNode> request;
	
	public BeanRecipesWebsite searchRecipe(BeanRecipesWebsite beanRecipesWebsite) throws IOException, InterruptedException, LessThan3IngredientsException {
			
		ArrayList<String> ingredients = (ArrayList<String>) beanRecipesWebsite.getRecipe().getListFoodName();
		if( ingredients.size() < 3) {
			throw new LessThan3IngredientsException( ingredients);
			
		}
		StringBuilder bld = new StringBuilder();
		for( String string : ingredients ) {
			bld.append( string + "," );
			
		}
		this.queryApi(bld.toString());
		
		
		JSONObject jo = this.request.getBody().getArray().getJSONObject(0);		     
		JSONArray jaUsed = (JSONArray) jo.get("usedIngredients");
		JSONArray jaMissed = (JSONArray) jo.get("missedIngredients");
		      
        
        
        ArrayList<String> content = new ArrayList<>();
        // setting content
        
        for( int i = 0; i< jaUsed.length(); i++) {

        	JSONObject joUsed = jaUsed.getJSONObject(i);
        	content.add( (String) joUsed.get("original"));
        	
        }
        
        for( int i = 0; i< jaMissed.length(); i++) {

        	JSONObject joMissed = jaMissed.getJSONObject(i);
        	content.add( (String) joMissed.get("original"));
        	
        }
        
		String title = (String) request.getBody().getArray().getJSONObject(0).get("title");
        
        
        String recipeImage = (String) request.getBody().getArray().getJSONObject(0).get("image");

		
		beanRecipesWebsite.getRecipe().setLink(recipeImage);
		beanRecipesWebsite.getRecipe().setContent(content);
		beanRecipesWebsite.getRecipe().setTitle(title);
		return beanRecipesWebsite;	
		
			
		
	}
	
	private void queryApi( String query) {

		try {
			this.request = Unirest.get( String.format( "https://api.spoonacular.com/recipes/findByIngredients?number=1&ranking=1&ignorePantry=false&ingredients=%s", query ) )
				      .header("accept", "application/json")
				      .queryString("apiKey", "182a4ed3fcac422bb77989c8be661be3")
				      .asJson();
		} catch (UnirestException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}