package com.sampleapp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sampleapp.service.UserService;

public class ViewUserProfileCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
		String forwardToJsp = "";		

		//We already have the User object stored in the session...
		//Just forward to the view (viewProfile.jsp)...
		forwardToJsp = "/viewProfile.jsp";	
	

		return forwardToJsp;
	}

}
