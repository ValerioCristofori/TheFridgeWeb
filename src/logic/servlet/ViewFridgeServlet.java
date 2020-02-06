package logic.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.boundary.ViewFridgeUI;
import logic.implementation.exceptions.EmptyException;

public class ViewFridgeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ViewFridgeUI viewFridgeUI;
	
	public ViewFridgeServlet() {
		viewFridgeUI = new ViewFridgeUI();
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{
		int index = Integer.parseInt( req.getParameter("index") );
		
		viewFridgeUI = new ViewFridgeUI();
		try {
			viewFridgeUI.showContent();		
			ArrayList<List<String>> data = (ArrayList<List<String>>) viewFridgeUI.getContent();
				
			String name =data.get(index).get(0);
			String quantity = data.get(index).get(1);
			viewFridgeUI.clickedOnRemoveFood(name, quantity);
			data.remove(index);
		
		} catch (EmptyException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, res);
	}
	
}
