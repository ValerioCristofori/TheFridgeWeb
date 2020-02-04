package logic.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.boundary.AddFoodUI;
import logic.implementation.ListAllFood;

public class AddFoodServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private AddFoodUI addFoodUI;
	
	public AddFoodServlet() {
		this.addFoodUI= new AddFoodUI();
	}
	
	public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			String date = req.getParameter("date");
			
			if( !addFoodUI.validSemanticName( name )  ) {
				RequestDispatcher rd = req.getRequestDispatcher("addFoodNameValid.html");
				rd.forward(req, res);
	    		return;		
	    	}
	    	if( !addFoodUI.validSyntaxQuantity( quantity )  ) {
	    		RequestDispatcher rd = req.getRequestDispatcher("addFoodQuantityValid.html");
				rd.forward(req, res);
	    		return;		
	    	}
	    	
	    	LocalDate expirationDate = LocalDate.parse(date);
	    	this.addFoodUI.clickOnInsertFood( name, quantity, expirationDate);
	    	RequestDispatcher rd = req.getRequestDispatcher("addFood.html");
			rd.forward(req, res);
		    	
		}
	    catch( DateTimeParseException dtpe) {
    		LocalDate expirationDate = null;
    		String name = req.getParameter("name");
    		int quantity = Integer.parseInt(req.getParameter("quantity"));
    		this.addFoodUI.clickOnInsertFood( name, quantity, expirationDate);
    		RequestDispatcher rd = req.getRequestDispatcher("addFood.html");
			rd.forward(req, res);
		}
	    catch( NumberFormatException ne ) {
	    	RequestDispatcher rd = req.getRequestDispatcher("addFoodQuantityValid.html");
			rd.forward(req, res);
	    }    	
		
	}
	
	public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		//mettere autocomplete
		String[] list = ListAllFood.getListAllFood();
		
		req.setAttribute("list", list );
		RequestDispatcher rd = req.getRequestDispatcher("addFood.html");
		rd.forward(req, res);
	}
	
}
