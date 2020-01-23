package logic.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.entity.Food;
import logic.entity.Fridge;
import logic.implementation.Queries;

public class DaoFood {
	
	public void saveFood( Food food, Fridge fridge) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			if( Queries.insertFoodInTheFridge( daoSingleton.stmt , food, fridge) == 1) {
				Logger logger = Logger.getLogger( 
						DaoFood.class.getName()); 
		        logger.log(Level.INFO, "insert" );
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	public void removeFood (Food food, int id) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			if( Queries.removeFoodInTheFridge( daoSingleton.stmt , food, id) == 1) {
				Logger logger = Logger.getLogger( 
						DaoFood.class.getName()); 
		        logger.log(Level.INFO, "remove" );
			}    
		    
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
}
