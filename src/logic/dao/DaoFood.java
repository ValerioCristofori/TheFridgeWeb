package logic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.entity.Food;
import logic.entity.Fridge;
import logic.implementation.Queries;
import logic.implementation.exceptions.DuplicatedFoodException;

public class DaoFood {
	
	public void saveFood( Food food, Fridge fridge) throws DuplicatedFoodException {
		
		try {
			insertFood(food,fridge);
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	private void insertFood(Food food, Fridge fridge) throws SQLException, DuplicatedFoodException {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			if( Queries.insertFoodInTheFridge( daoSingleton.stmt , food, fridge) == 1) {
				Logger logger = Logger.getLogger( 
						DaoFood.class.getName()); 
		        logger.log(Level.INFO, "insert" );
			}
		}catch(SQLIntegrityConstraintViolationException e) {
			ResultSet rs = Queries.takeFoodQuantity(daoSingleton.stmt , food.getName(), fridge.getId());
			rs.first();
			throw new DuplicatedFoodException( food.getName(), rs.getInt("quantity"));
		}
	}
	
	public void saveSafelyFood( Food food, Fridge fridge){
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
