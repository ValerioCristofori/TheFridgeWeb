package logic.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.boundary.ChooseRecipesUI;

public class ChooseRecipesServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private ChooseRecipesUI chooseRecipesUI;
	private static final String PAGE = "recipes.jsp";
	
	
	public ChooseRecipesServlet() {
		this.chooseRecipesUI= new ChooseRecipesUI();
	}
	
	
	
	public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		
		try {
		     String[] selectedFoods = req.getParameterValues("foods") ;
		     int numRecipes = Integer.parseInt(req.getParameter("recipesnumber"));
		     if( numRecipes < 1 || numRecipes > 5) {
		    	 req.setAttribute("alertLabel", "Insert number of recipes(1 to 5)");
				 RequestDispatcher rd = req.getRequestDispatcher(PAGE);
				 rd.forward(req, res);
		     }
		     List<String> list = null;
		     if( selectedFoods != null ) {
		    	 list = new ArrayList<>();
		         
		    	 for (int i=0; i<selectedFoods.length; i++) {
		             list.add(i, selectedFoods[i]);
		         }
		         
		     }
		     this.chooseRecipesUI.clickedOnStartSearch( list , numRecipes);
		     
		     int size = chooseRecipesUI.getImages().size();
		     req.setAttribute( "size" , size );
		     if( size != 0) {
				for( int i=0 ; i<size; i++) {
					req.setAttribute( String.valueOf(i) , chooseRecipesUI.getImages().get(i) );
					req.setAttribute( String.format("title%d", i) , chooseRecipesUI.getTitles().get(i) );
					StringBuilder bld = new StringBuilder();
					
		    		for( String string : chooseRecipesUI.getContents().get(i) ) {
		    			bld.append(string + "\n");
		    			 
		    		}
					req.setAttribute( String.format("content%d", i) , bld.toString() );
				}
				
				RequestDispatcher rd = req.getRequestDispatcher(PAGE);
				rd.forward(req, res); 
			}
		}catch( NumberFormatException e) {
			req.setAttribute("alertLabel", "Insert number of recipes(1 to 5)");
			RequestDispatcher rd = req.getRequestDispatcher(PAGE);
			rd.forward(req, res);
		}catch( NullPointerException ne ) {
			req.setAttribute("alertLabel2", "You cannot search for recipes with an empty fridge");
			RequestDispatcher rd = req.getRequestDispatcher(PAGE);
			rd.forward(req, res);
		}
	  

		
			
	    	
		   	
		
	}
}
