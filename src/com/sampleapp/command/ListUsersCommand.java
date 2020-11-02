package com.sampleapp.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sampleapp.business.User;
import com.sampleapp.service.UserService;

public class ListUsersCommand implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		UserService userService = new UserService();
		String forwardToJsp = "";
		HttpSession session = request.getSession();
		
		//Make the call to the 'Model' by using the UserService class to get all Users...
		List<User> users = new ArrayList<User>();
		users = userService.getAllUsers();

		//Put the list of users into the session so that JSP(the View) can pick them up and display them...
		session.setAttribute("users", users);
		forwardToJsp = "/listUsers.jsp";	

		return forwardToJsp;
	}

}

