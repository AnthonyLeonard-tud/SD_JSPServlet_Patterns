package com.sampleapp.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sampleapp.business.User;
import com.sampleapp.service.UserService;

public class EditUserProfileCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		UserService userService = new UserService();
		String forwardToJsp = "";		

		int id =  Integer.valueOf(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	 			
		userService.updateUserBasedOnUserId(id, firstName, lastName, username, password);
		
		User ammendedLoggingIn = userService.findUserById(id);
		
		if (ammendedLoggingIn != null){

			//If login successful, store the session id for this client...
			HttpSession session = request.getSession();
			String clientSessionId = session.getId();
			session.setAttribute("loggedSessionId", clientSessionId);
			session.setAttribute("user", ammendedLoggingIn);
			
			List<User> users = new ArrayList<User>();
			users = userService.getAllUsers();
			
			session.setAttribute("users", users);

			forwardToJsp = "/listUsers.jsp";				
		}
		else{
			forwardToJsp = "/errorPage.jsp";	
		}
		
		return forwardToJsp;
	}

}
