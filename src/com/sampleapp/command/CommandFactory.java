package com.sampleapp.command;

import java.lang.reflect.InvocationTargetException;

import com.sampleapp.exceptions.CommandCreationExeption;

public class CommandFactory {

    private static CommandFactory factory = null;

    private CommandFactory() {
    }

    /**
     * Get an instance of the CommandFactory
     * @return The singleton CommandFactory object
     */
    public synchronized static CommandFactory getInstance() {
        if (factory == null) {      // first time

            factory = new CommandFactory();
        }
        return factory;
    }

    /**
     * 
     * @param commandStr Identifier for the exact Command object required
     * @return The specific Command object requested
     * @throws ClassNotFoundException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     */
    public synchronized Command createCommand(String commandStr) throws CommandCreationExeption, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	Command command = null;

    	/*
    	//Instantiate the required Command object...
    	if (commandStr.equals("LoginUser")) {
    		command = new LoginUserCommand();
    	}
    	if (commandStr.equals("ListUsers")) {
    		command = new ListUsersCommand();
    	}
    	if (commandStr.equals("ViewUserProfile")) {
    		command = new ViewUserProfileCommand();
    	}
    	if (commandStr.equals("EditUserProfile")) {
    		command = new EditUserProfileCommand();
    	}
		*/
    	
    	String packageName = "com.sampleapp.command.";
    	
    	try {
    		commandStr = packageName + commandStr + "Command";
    		Class<?> theClass = Class.forName(commandStr);
    		Object theObject = theClass.getDeclaredConstructor().newInstance();
    		command = (Command)theObject;
    	} catch (InstantiationException e) {
    		throw new CommandCreationExeption("CommandFactory" + e);
    	} catch (IllegalAccessException e) {
    		throw new CommandCreationExeption("CommandFactory" + e);
    	} catch (ClassNotFoundException e) {
    		throw new CommandCreationExeption("CommandFactory" + e);
    	} catch (InvocationTargetException e) {
    		throw new CommandCreationExeption("CommandFactory" + e);
    	}
    	
    	//Return the instantiated Command object to the calling code...
    	return command; // may be null

    }
    
}

