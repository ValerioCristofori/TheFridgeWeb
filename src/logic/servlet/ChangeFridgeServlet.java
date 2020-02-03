package logic.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.boundary.ChangeFridgeUI;
import logic.implementation.exceptions.TooManyFridgesException;
import logic.implementation.gof.SingletonInstances;

public class ChangeFridgeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ChangeFridgeUI changeFridgeUI;
	private static final String PAGE = "changeFridge.jsp";

	
	public ChangeFridgeServlet() {
		this.changeFridgeUI = new ChangeFridgeUI();
	}
	
	public void doGet( HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		SingletonInstances instances = SingletonInstances.getSingletonInstance();
		req.setAttribute("label-username", instances.getCurrentUser().getUsername() );
		
		RequestDispatcher rd = req.getRequestDispatcher(PAGE);
		rd.forward(req, res); 
    	
    	
    	
	}
	
	public void doPost( HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		this.changeFridgeUI.takeInvitations();
		ArrayList<String> listInviting = (ArrayList<String>) this.changeFridgeUI.getInvitingUsers();
		 
		
		if ( action.equals("accept")) {
			int i = Integer.parseInt( req.getParameter("index") );
		    try {
				this.changeFridgeUI.clickedOnAcceptInvitation(listInviting.get(i));
				//rimuovo da lista
				listInviting.remove(i);
				RequestDispatcher rd = req.getRequestDispatcher(PAGE);
				rd.forward(req, res);
	    			
			} catch (TooManyFridgesException e) {
				e.printStackTrace();
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
