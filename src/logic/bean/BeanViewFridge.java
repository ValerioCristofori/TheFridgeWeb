package logic.bean;

import java.util.ArrayList;
import java.util.List;

import logic.entity.Food;

public class BeanViewFridge {
	private int id;
	private String name;
	private ArrayList<Food> listOfFood;
	private String foodName;
	private int foodQuantity;	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the listOfFood
	 */
	public List<Food> getListOfFood() {
		return listOfFood;
	}
	/**
	 * @param listOfFood the listOfFood to set
	 */
	public void setListOfFood(List<Food> listOfFood) {
		this.listOfFood = (ArrayList<Food>) listOfFood;
	}
	/**
	 * @return the foodName
	 */
	public String getFoodName() {
		return foodName;
	}
	/**
	 * @param foodName the foodName to set
	 */
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	/**
	 * @return the foodQuantity
	 */
	public int getFoodQuantity() {
		return foodQuantity;
	}
	/**
	 * @param foodQuantity the foodQuantity to set
	 */
	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
}
