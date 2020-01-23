package logic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.boundary.ShareFridgeUI;

public class InviteUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ShareFridgeUI shareFridgeUI;
	
	public InviteUserServlet() {
		this.shareFridgeUI = new ShareFridgeUI();
	}
	
	public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		
			String username = req.getParameter("username");
			//String email = req.getParameter("email");
			String message = req.getParameter("message");
			
			if( !shareFridgeUI.isValidUsername(username) ) {
				
				req.setAttribute("label", "Username not valid");
				RequestDispatcher rd = req.getRequestDispatcher("inviteUsers.jsp");
				rd.forward(req, res);
	    		return;		
			}		
		
			this.shareFridgeUI.clickedOnInviteWithUsername(username, message);
			RequestDispatcher rd = req.getRequestDispatcher("inviteUsers.jsp");
			rd.forward(req, res);
			
			}
			   	 
	

}






