package logic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.entity.Fridge;
import logic.entity.Invitation;
import logic.implementation.Queries;
import logic.implementation.exceptions.EmptyException;

public class DaoInvitation {
	
	public void sendInvitationDB( Invitation invitation ) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			if( Queries.insertInvitation( daoSingleton.stmt , invitation.getInvitingUser(), invitation.getInvitedUser(), invitation.getMessage() ) == 1) {
				Logger logger = Logger.getLogger( 
						DaoInvitation.class.getName()); 
		        logger.log(Level.INFO, "insert invitation" );
			}
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	public List<Invitation> takeInvitationsFromDB( String username ) throws EmptyException {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		ArrayList<Invitation> invitationList = new ArrayList<>();
		try {
			ResultSet rs = Queries.selectInvitations( daoSingleton.stmt , username );
			
			if (!rs.first()){ // rs empty
            	throw new EmptyException("Frigo vuoto!");
            }
			// riposizionamento rs
			rs.first();
            do{
                // lettura delle colonne "by name"
                String invitingUser = rs.getString("invitingUser");
                String invitedUser = rs.getString("invitedUser");
                String message = rs.getString("message");
                
                Invitation invitation = new Invitation();
                invitation.setInvitingUser(invitingUser);
                invitation.setInvitedUser(invitedUser);
                invitation.setMessage(message);
                
                invitationList.add(invitation);

            }while(rs.next());
            
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return invitationList;
	}
	
	public void deleteInvitationFromDB( Invitation invitation ) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			
			if( Queries.deleteInvitation( daoSingleton.stmt , invitation.getInvitingUser(), invitation.getInvitedUser() ) == 1 ){
				Logger logger = Logger.getLogger( 
						DaoInvitation.class.getName()); 
		        logger.log(Level.INFO, "remove invitation" );
			}

		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	public void startMembership( Invitation invitation, Fridge fridge ) {
		DaoEntity daoSingleton = DaoEntity.getSingletonInstance();
		try {
			if( Queries.insertMembership( daoSingleton.stmt , invitation.getInvitedUser(), fridge.getId() ) == 1) {
				Logger logger = Logger.getLogger( 
						DaoInvitation.class.getName()); 
		        logger.log(Level.INFO, "insert membership" );
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
}
