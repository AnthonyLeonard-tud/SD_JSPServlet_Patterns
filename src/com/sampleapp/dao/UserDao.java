package com.sampleapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sampleapp.business.User;
import com.sampleapp.exceptions.DaoException;


public class UserDao extends Dao {

    public List<User> findAllUsers() throws DaoException {
        
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();
        
        try {
        	//Get connectino object using the methos in the super class (Dao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM USER";
            ps = con.prepareStatement(query);
            
            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("ID");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String lastname = rs.getString("LAST_NAME");
                String firstname = rs.getString("FIRST_NAME");
                User u = new User(userId, firstname, lastname, username, password);
                users.add(u);
        }
        } catch (SQLException e) {
            throw new DaoException("findAllUsers() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }
        }
        return users;     // may be empty
    }

    /*
     * This method is NOT susceptible to SQL Injection
     */
    public User findUserByUsernamePassword(String uname, String pword) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pword);
            
            rs = ps.executeQuery();
            if (rs.next()) {
            	int userId = rs.getInt("ID");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String lastname = rs.getString("LAST_NAME");
                String firstname = rs.getString("FIRST_NAME");
                u = new User(userId, firstname, lastname, username, password);
            }
        } catch (SQLException e) {
            throw new DaoException("findUserByUsernamePassword " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("findUserByUsernamePassword" + e.getMessage());
            }
        }
        return u;     // p may be null 
    }
    
    public User findUserByUserId(int id) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM USER WHERE ID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if (rs.next()) {
            	int userId = rs.getInt("ID");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String lastname = rs.getString("LAST_NAME");
                String firstname = rs.getString("FIRST_NAME");
                u = new User(userId, firstname, lastname, username, password);
            }
        } catch (SQLException e) {
            throw new DaoException("findUserByUsernamePassword " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("findUserByUsernamePassword" + e.getMessage());
            }
        }
        return u;     // p may be null 
    }

	public void updateUserBasedOnUserId(int id, String firstName, String lastName, String username, String password) throws DaoException {
		Connection con = null;
        PreparedStatement ps = null;
        try {
            con = this.getConnection();
            
            String query = "UPDATE USER SET FIRST_NAME =?, LAST_NAME =?, USERNAME = ?, PASSWORD = ? WHERE ID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setInt(5, id);
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new DaoException("updateUserBasedOnUserId " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("updateUserBasedOnUserId" + e.getMessage());
            }
        }
	}
   
}
