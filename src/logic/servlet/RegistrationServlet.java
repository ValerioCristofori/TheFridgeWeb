package logic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.boundary.RegistrationUI;

public class RegistrationServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private RegistrationUI registrationUI;
	
	public RegistrationServlet() {
		this.registrationUI = new RegistrationUI();
	}
	
	public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		
		String username = req.getParameter( "username" );
		String email = req.getParameter( "email" );
		String password = req.getParameter( "password" );
		
		if( !registrationUI.validSyntaxUsername(username) ) {
			//error message
			req.setAttribute("label", "Username not valid (from 4 to 30 chars)");
			RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
			rd.forward(req, res);
			return;
		}		
		if( !registrationUI.validSyntaxEmail(email) ) {
			//error message
			req.setAttribute("label", "Email not valid");
			RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
			rd.forward(req, res);
			return;
		}
		if( !registrationUI.validSyntaxPassword(password) ) {
			//error message
			req.setAttribute("label", "Password not valid, (from 6 to 30 chars)");
			RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
			rd.forward(req, res);
			return;
		}
		if( registrationUI.notExist(username, email , password) ) {
			registrationUI.clickedOnRegistration( username, email , password);
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, res);
		}
		else {
			req.setAttribute("label", "Username or email already exist");
			RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
			rd.forward(req, res);
		}
	}
}
