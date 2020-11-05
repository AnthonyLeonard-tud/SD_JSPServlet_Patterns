package com.sampleapp.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sampleapp.command.Command;
import com.sampleapp.command.CommandFactory;
import com.sampleapp.exceptions.CommandCreationExeption;

/**
 * Servlet implementation class UserController
 */
@WebServlet(urlPatterns={"/UserController"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest (request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}	
	
	
	/**
	 * Common method to process all client requests (GET and POST)
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {

		String forwardToJsp = null;		
				
		/*
		 * NOTE: THIS SECTION OF THE CODE DEALS WITH CHECKING LOGIN DETAILS...
		 */		
		// process other actions...
		String action = request.getParameter("action");
		
		//Check if this is a login request and process...
		if ( action.equalsIgnoreCase("LoginUser") ){

			// special case the user wants to log in...
			CommandFactory factory = CommandFactory.getInstance();
			Command command = null;
			try {
				command = factory.createCommand(action);
				forwardToJsp = command.execute(request, response);		
			} catch (Exception e) {
				e.printStackTrace();
				forwardToJsp = "/errorPage.jsp";		
			}
			forwardToJsp = command.execute(request, response);

		}
		else{	
			//If not a login request then need to check that user is  
			//logged in before processing ANY other type of requests.
			
			//Check to see if the session id coming from the client matches the id stored at login...
			HttpSession session = request.getSession();

			//If user not logged in...
			if ( session.getId() != session.getAttribute("loggedSessionId") ){
				forwardToJsp = "/loginFailure.jsp";
				forwardToPage(request, response, forwardToJsp);
				return;
			}
						
			CommandFactory factory = CommandFactory.getInstance();
			Command command = null;
			
			try {
				command = factory.createCommand(action);
				forwardToJsp = command.execute(request, response);		
			} catch (Exception e) {
				e.printStackTrace();
				forwardToJsp = "/errorPage.jsp";		
			}
		}			

		forwardToPage(request, response, forwardToJsp);
	}
	
	
	/**
	 * Forward to server to the supplied page
	 */
	private void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page){
		
		//Get the request dispatcher object and forward the request to the appropriate JSP page...
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
