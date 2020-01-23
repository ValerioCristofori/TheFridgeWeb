package logic.entity;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
	private ArrayList<String> listFoodName;
	private String link;
	/**
	 * @return the listFoodName
	 */
	public List<String> getListFoodName() {
		return listFoodName;
	}
	/**
	 * @param listFoodName the listFoodName to set
	 */
	public void setListFoodName(List<String> listFoodName) {
		this.listFoodName = (ArrayList<String>) listFoodName;
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
	
	@Override
	public String toString() {
		return String.format("ricetta: '%s' %ningredienti: '%s' %n'%s' %n'%s'" , this.link , this.listFoodName.get(0) , this.listFoodName.get(1) , this.listFoodName.get(2) ) ;
	}

}