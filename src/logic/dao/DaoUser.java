package logic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.entity.Fridge;
import logic.entity.User;
import logic.implementation.Queries;
import logic.implementation.exceptions.EmptyException;

public class DaoUser{
	
	
	public void saveRegistrationToDB(User user) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			if( Queries.insertUser( daoSingleton.stmt , user) == 1) {
				Logger logger = Logger.getLogger( 
						DaoUser.class.getName()); 
		        logger.log(Level.INFO, "insert user" );
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
	}
	
	public boolean checkValidUsername( User user ) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try{
			ResultSet rs = Queries.checkUsernameExistence(daoSingleton.stmt, user.getUsername() );
		
	        if (!rs.first()){ // rs empty
	        	// username non usato
	        	return false;
	        }
	    
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return true;
	}
	
	public boolean checkValidEmail( User user ) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try{
			ResultSet rs = Queries.checkEmailExistence(daoSingleton.stmt, user.getEmailAddress() );
		
	        if (!rs.first()){ // rs empty
	        	// username non usato
	        	return false;
	        }
	    
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return true;
	}
	
	public String takePassword ( User user ) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			ResultSet rs = Queries.selectPassword( daoSingleton.stmt, user.getUsername() );
			
			rs.first();
			return rs.getString("password");
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
	
	public String takeEmailFromDB( User user ) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			ResultSet rs = Queries.selectEmailAddress( daoSingleton.stmt, user.getUsername() );
			rs.first();
			
			return rs.getString("emailAddress");
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
	
	public Fridge getFridgeOfUser( User user ){
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		Fridge fridge = new Fridge();
		try {
			ResultSet rs = Queries.selectFridge( daoSingleton.stmt , user.getUsername() );
			
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
	
	public void deleteUser( User user ) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			if( Queries.deleteUserForUsername( daoSingleton.stmt , user.getUsername() ) == 1) {
				Logger logger = Logger.getLogger( 
						DaoUser.class.getName()); 
		        logger.log(Level.INFO, "remove user" );
			}
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	public List<Fridge> takeFridgesFromDB( User user ) throws EmptyException{
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		ArrayList<Fridge> listOfFridges = new ArrayList<>();
		try {
			ResultSet rs = Queries.selectMyFridges( daoSingleton.stmt , user.getUsername());
			
			if (!rs.first()){ // rs empty
            	throw new EmptyException("Frigo vuoto!");
            }
			
			// riposizionamento rs
			rs.first();
            do{
                // lettura delle colonne "by name"
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                
                
                Fridge fridge = new Fridge();
                fridge.setId(id);
                fridge.setName(name);
                
                listOfFridges.add(fridge);

            }while(rs.next());
            return listOfFridges;
            
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return listOfFridges;
	}
	
	public int countMembership( User user ) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			int count = 0;
			ResultSet rs = Queries.countMembershipOfUser( daoSingleton.stmt , user.getUsername() );
			rs.first();
			do{
				count++;
			}while( rs.next() );
			return count;
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
			return 0;
	}
	
	public String takeUsernameFromDB( String email ) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			ResultSet rs = Queries.selectUsername( daoSingleton.stmt, email );
			rs.first();
			
			return rs.getString("Username");
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
}
