package logic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import logic.boundary.ChooseRecipesUI;

public class ChooseRecipesServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private ChooseRecipesUI chooseRecipesUI;
	
	
	
	public ChooseRecipesServlet() {
		this.chooseRecipesUI= new ChooseRecipesUI();
	}
	
	
	
	public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		
		
	     String selectedFoods[] = req.getParameterValues("foods") ;
	     int numRecipes = Integer.parseInt(req.getParameter("recipesnumber"));
	     List<String> list = null;
	     if( selectedFoods != null ) {
	    	 list = new ArrayList<String>(selectedFoods.length);
	         for (String s:selectedFoods) {
	             list.add( s );
	         }
	     }
	     this.chooseRecipesUI.clickedOnStartSearch( list , numRecipes);
	     
	     int size = chooseRecipesUI.getImages().size();
	     req.setAttribute( "size" , size );
	     if( size != 0) {
			for( int i=0 ; i<size; i++) {
				req.setAttribute( String.valueOf(i) , chooseRecipesUI.getImages().get(i) );
				req.setAttribute( String.format("title%d", i) , chooseRecipesUI.getTitles().get(i) );
				String recipeString = "";
	    		for( String string : chooseRecipesUI.getContents().get(i) ) {
	    			recipeString = recipeString + "\n" + string; 
	    		}
				req.setAttribute( String.format("content%d", i) , recipeString );
			}
			
			RequestDispatcher rd = req.getRequestDispatcher("recipes.jsp");
			rd.forward(req, res); 
		}
		else {
			System.out.println("empty");
			//eccezione no ricette
			
		}
	  

		
			
	    	
		   	
		
	}
}
