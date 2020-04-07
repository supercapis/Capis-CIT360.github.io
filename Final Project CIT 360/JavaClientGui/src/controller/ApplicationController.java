package controller;

import controller.handlers.AddressHandler;
import controller.handlers.CityStateHandler;
import controller.handlers.Handler;
import controller.handlers.ZipCodeListHandler;

import java.util.HashMap;

/**
 * This Class Implements the Application Controller Pattern
 * Maps three handlers for the application
 */
public class ApplicationController {
    
  /**
   * static variable for class instance
   */  
  private static ApplicationController controllerInstance = null;

    /**
     * This the hashMap that controls the Application access to Handler classes
     */
    private HashMap<String, Handler> commandHandler;

    /**
     * These are all handler aliases mapped for the Application Controller:
     * - searchAddress
     * - searchCityState
     * - searchList
     */
    public ApplicationController() {
        commandHandler = new HashMap<String, Handler>();
        commandHandler.put("searchAddress", new AddressHandler());
        commandHandler.put("searchCityState", new CityStateHandler());
        commandHandler.put("searchList", new ZipCodeListHandler());
    }
    
    /**
     *  Singleton method for class instance
     * @return ApplicationController instance
     */
    public static ApplicationController getInstance(){
        if (controllerInstance == null){
            controllerInstance = new ApplicationController();
        }
        return controllerInstance;
    }

    /**
     * This is the main method called for classes trying to exchange data with any handler in the application.
     * It throws an exception when desiredHandlers are not mapped in this controller.
     * @param commandKey
     * @param commandData
     * @return
     * @throws Exception
     */
    public Object doCommand(String commandKey, HashMap<String, Object> commandData) throws Exception {
        Handler command = commandHandler.getOrDefault(commandKey, null);
        if (command == null) {
            throw new Exception("There is no Handler mapped for [" + commandKey + "].");
        }
        return command.handleIt(commandData);
    }
}
