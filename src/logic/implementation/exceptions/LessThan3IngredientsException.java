package logic.implementation.exceptions;

import java.util.ArrayList;
import java.util.List;

public class LessThan3IngredientsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ArrayList<String> ingredients;
	
	public LessThan3IngredientsException( List<String> ingr ) {
		this.ingredients = (ArrayList<String>) ingr;
	}

	/**
	 * @return the ingredients
	 */
	public List<String> getIngredients() {
		return ingredients;
	}

}
