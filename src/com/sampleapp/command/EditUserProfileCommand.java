package com.sampleapp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sampleapp.service.UserService;

public class EditUserProfileCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		UserService userService = new UserService();
		String forwardToJsp = "";		

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	 	
		System.out.println(firstName + " - " + lastName + " - " + username + " - " + password);
		
		forwardToJsp = "/loginSuccess.jsp";	
		
		return forwardToJsp;
	}

}
