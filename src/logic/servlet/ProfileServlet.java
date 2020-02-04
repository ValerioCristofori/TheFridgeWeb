package logic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.boundary.ChangeFridgeUI;

	public class ProfileServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private ChangeFridgeUI changeFridgeUI;

	
	public ProfileServlet() {
		this.changeFridgeUI = new ChangeFridgeUI();
	}
	
	public void doPost( HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("actionProfileName");
		String action2 = req.getParameter("actionProfile");
		
		if( action.equals("changeInMyFridge")) {
			this.changeFridgeUI.clickedOnChangeInMyFridge();
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, res);
		}
		else if( action.equals("Logout")) {
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.forward(req, res);
		}
		

		if( action2.equals("DeleteAccount")) {
			this.changeFridgeUI.clickedOnDeleteAccount();
			//aggiungere il fatto che non si può tornare indietro una volta fatto il delete
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.forward(req, res);
		}
	}
}
