package logic.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.boundary.ChangeFridgeUI;
import logic.implementation.exceptions.EmptyInvitationException;
import logic.implementation.exceptions.TooManyFridgesException;

public class ChangeFridgeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ChangeFridgeUI changeFridgeUI;
	private static final String PAGE = "changeFridge.jsp";

	
	public ChangeFridgeServlet() {
		this.changeFridgeUI = new ChangeFridgeUI();
	}
	
	public void doPost( HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		ArrayList<String> listInviting = null;
		try {
			this.changeFridgeUI.takeInvitations();
			 listInviting = (ArrayList<String>) this.changeFridgeUI.getInvitingUsers();
		} catch (EmptyInvitationException e1) {
			Logger logger = Logger.getLogger( 
	        		ChangeFridgeServlet.class.getName()); 
	        logger.log(Level.WARNING, "empty invitation list");
		}
		
		 
		
		if ( action.equals("accept")) {
			int i = Integer.parseInt( req.getParameter("index") );
		    try {
				this.changeFridgeUI.clickedOnAcceptInvitation(listInviting.get(i));
				//rimuovo da lista
				listInviting.remove(i);
				RequestDispatcher rd = req.getRequestDispatcher(PAGE);
				rd.forward(req, res);
	    			
			} catch (TooManyFridgesException e) {
				req.setAttribute("alertLabel", e.getMess());
				RequestDispatcher rd = req.getRequestDispatcher(PAGE);
				rd.forward(req, res);
			}
		    
		}
		else if (action.equals("decline") ) {
			int i = Integer.parseInt( req.getParameter("index") );
		    this.changeFridgeUI.clickedOnDeclineInvitation(listInviting.get(i));
		    //rimuovo da lista
			listInviting.remove(i);
		    RequestDispatcher rd = req.getRequestDispatcher(PAGE);
			rd.forward(req, res);
    			
		}
		else if( action.equals("change") ) {
			int i = Integer.parseInt( req.getParameter("fridge") );
			this.changeFridgeUI.startFridgesInterfaces();
			this.changeFridgeUI.clickedOnChangeFridge(i);
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, res);
		}
		
		
	}
}
