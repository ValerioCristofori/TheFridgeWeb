package logic.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.bean.BeanViewFridge;
import logic.controller.ViewFridgeController;
import logic.implementation.exceptions.EmptyException;

public class ViewFridgeUI{
	private ArrayList<List<String>> data;
	
	public ViewFridgeUI() {
		this.data = new ArrayList<>();
	}
	
	public void showContent() {
		try { 
			ViewFridgeController viewFridgeCTRL = new ViewFridgeController();
			BeanViewFridge beanViewFridge = viewFridgeCTRL.takeContent();
			
			for (int i = 0; i < beanViewFridge.getListOfFood().size() ; i++) {
		        List<String> row = new ArrayList<>();
		        row.add( beanViewFridge.getListOfFood().get(i).getName() );
		        row.add( String.format("%s", beanViewFridge.getListOfFood().get(i).getQuantity() ) );
		        row.add( beanViewFridge.getListOfFood().get(i).getExpirationDate() );		            

		        this.data.add(row);

		    }			
			
		}catch(EmptyException ee) {
			// creo un Logger 
	        Logger logger = Logger.getLogger( 
	        		ViewFridgeUI.class.getName()); 
	        logger.log(Level.WARNING, "empty fridge");
		}
	}
	
	public void clickedOnChangeNameFridge( String name ) {
		ViewFridgeController viewFridgeCTRL = new ViewFridgeController();
		viewFridgeCTRL.changeFridgeName( name );
	}
	
	public void clickedOnRemoveFood(String name, String quantity ) {
		BeanViewFridge beanViewFridge = new BeanViewFridge();
		beanViewFridge.setFoodName(name);
		int i = Integer.parseInt(quantity);
		beanViewFridge.setFoodQuantity(i);
		ViewFridgeController viewFridgeCTRL = new ViewFridgeController();
		viewFridgeCTRL.removeFood(beanViewFridge);	
	}
	
	public List<List<String>> getContent(){
		return this.data;
	}
	
	
	
}
