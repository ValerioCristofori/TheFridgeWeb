package logic.bean;

import java.util.ArrayList;
import java.util.List;

import logic.entity.Recipe;

public class BeanChooseRecipes {
	private ArrayList<Recipe> listRecipe;
	private ArrayList<String> listFood;
	private int numRecipes;
	private String link;

	/**
	 * @return the listFood
	 */
	public List<String> getListFood() {
		return listFood;
	}

	/**
	 * @param listFood the listFood to set
	 */
	public void setListFood(List<String> listFood) {
		this.listFood = (ArrayList<String>) listFood;
	}

	/**
	 * @return the numRecipes
	 */
	public int getNumRecipes() {
		return numRecipes;
	}

	/**
	 * @param numRecipes the numRecipes to set
	 */
	public void setNumRecipes(int numRecipes) {
		this.numRecipes = numRecipes;
	}

	/**
	 * @return the listRecipe
	 */
	public List<Recipe> getListRecipe() {
		return listRecipe;
	}

	/**
	 * @param listRecipe the listRecipe to set
	 */
	public void setListRecipe(List<Recipe> listRecipe) {
		this.listRecipe = (ArrayList<Recipe>) listRecipe;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}


}
