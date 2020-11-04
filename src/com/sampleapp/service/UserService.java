package com.sampleapp.service;

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
	
	public User findUserById(int id){
		
		User u = null;
		try {
			UserDao dao = new UserDao();
			u = dao.findUserByUserId(id);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return u;
		
	}
	
	public User updateUserBasedOnUserId(int id, String firstName, String lastName,  String username, String password){
		
		User u = null;
		try {
			UserDao dao = new UserDao();
			dao.updateUserBasedOnUserId(id, firstName, lastName, username, password);
			u = dao.findUserByUserId(id);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return u;
		
	}
	
}
