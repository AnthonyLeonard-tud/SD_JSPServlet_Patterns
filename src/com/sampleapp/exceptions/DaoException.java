/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sampleapp.exceptions;

import java.sql.SQLException;

/**
 *
 * @author kellys
 */
public class DaoException extends SQLException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoException() {
    }

    public DaoException(String aMessage) {
        super(aMessage);
    }
}
