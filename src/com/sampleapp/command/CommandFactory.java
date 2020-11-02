package com.sampleapp.command;

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
     */
    public synchronized Command createCommand(String commandStr) {
    	Command command = null;

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

    	//Return the instantiated Command object to the calling code...
    	return command;		// may be null

    }
    
}

