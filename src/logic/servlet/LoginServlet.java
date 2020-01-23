package logic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.boundary.LoginUI;

public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private LoginUI loginUI;
	
	public LoginServlet() {
		this.loginUI = new LoginUI();
	}
	
	public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if( this.loginUI.isValid(username, password) ) {
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, res);
		}else {
			req.setAttribute("label", "Username or password not valid");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, res);
		}
		
	}
}
