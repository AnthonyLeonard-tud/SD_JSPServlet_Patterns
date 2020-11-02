package com.sampleapp.service;

import java.util.ArrayList;
import java.util.List;

import com.sampleapp.business.User;
import com.sampleapp.dao.UserDao;
import com.sampleapp.exceptions.DaoException;

public class UserService {
	
	public User login(String username, String password){
		
		User u = null;
		try {
			UserDao dao = new UserDao();
			u = dao.findUserByUsernamePassword(username, password);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return u;
		
	}
	
	public List<User> getAllUsers(){
		
		List<User> users = null;
		
		try {
			UserDao dao = new UserDao();
			users = dao.findAllUsers();
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return users;
		
	}
	
	
}
