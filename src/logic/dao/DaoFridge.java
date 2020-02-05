package logic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.entity.Food;
import logic.entity.Fridge;
import logic.entity.User;
import logic.implementation.Queries;
import logic.implementation.exceptions.EmptyException;

public class DaoFridge {
	
	public void createFridge( Fridge fridge ) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			if( Queries.insertFridge( daoSingleton.stmt , fridge) == 1 ) {
				Logger logger = Logger.getLogger( 
						DaoFridge.class.getName()); 
		        logger.log(Level.INFO, "insert" );
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	public boolean checkFridgeID( Fridge fridge ) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try{
			ResultSet rs = Queries.checkID(daoSingleton.stmt, fridge );
		
	        if (!rs.first()){ // rs empty
	        	// id non usato
	        	return true;
	        }
	    
		}catch(SQLException se) {
			se.printStackTrace();
		} 
		return false;
	}
	
	public Fridge getFridgeById( int id ) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		Fridge fridge = new Fridge();
		try {
			ResultSet rs = Queries.selectFridgeById( daoSingleton.stmt , id );
			
			// riposizionamento rs
			rs.first();
           
            fridge.setId(rs.getInt("ID") );
            fridge.setName(rs.getString("name") );
            
            return fridge;
            
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return fridge;
	}
	
	public void createAdministration( Fridge fridge, User admin) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			if( Queries.insertAdministration( daoSingleton.stmt , admin.getUsername(), fridge) == 1) {
				Logger logger = Logger.getLogger( 
						DaoFridge.class.getName()); 
		        logger.log(Level.INFO, "insert administration" );
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	public List<Food>  getContentFridge( Fridge fridge ) throws EmptyException {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		ArrayList<Food> listOfFood = new ArrayList<>();
		try {
			ResultSet rs = Queries.selectContentFridge( daoSingleton.stmt , fridge);
			
			if (!rs.first()){ // rs empty
            	throw new EmptyException("Empty fridge!");
            }
			// riposizionamento rs
			rs.first();
            do{
                // lettura delle colonne "by name"
                String foodName = rs.getString("name");
                int quantity = rs.getInt("quantity");
                String expirationDate = rs.getString("expirationDate");
                
                
                Food food = new Food();
                food.setName(foodName);
                food.setQuantity(quantity);
                food.setExpirationDate(expirationDate);
                
                listOfFood.add(food);

            }while(rs.next());
            
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return listOfFood;
	} 
	
	
	public void updateFridgeNameInDB( Fridge fridge ) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			if( Queries.updateFridgeName( daoSingleton.stmt , fridge.getId(), fridge.getName() ) == 1) {
				Logger logger = Logger.getLogger( 
						DaoFridge.class.getName()); 
		        logger.log(Level.INFO, "update fridge name" );
			}
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
}
	
