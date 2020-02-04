package logic.entity;

import java.util.ArrayList;
import java.util.List;


public class Fridge {
	private int id;
	private String name;
	private ArrayList<Food> listOfFood;
	
	public Fridge() {
		this.setId(0);
		this.name = "fridge";
		this.listOfFood = null;
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
	
	
	@Override
	public String toString() {
		return String.format("fridge: " + this.id + "\n" + "name: " + this.name + "\n" + "content: " + this.listOfFood);
	}

}
