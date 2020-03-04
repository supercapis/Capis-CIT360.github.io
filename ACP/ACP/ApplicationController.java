package ACP;

import Handlers.ClassesHandler;
import Handlers.Handler;
import Handlers.StudentsHandler;

import java.util.HashMap;

public class ApplicationController {

    /**
     * This the hashmap that controls the Application access to Handler classes
     */
    private HashMap<String, Handler> commandHandler;

    /**
     * These are all handler aliases mapped for the Application Controller:
     * - showStudents
     * - displayClasses
     */
    public ApplicationController() {
        commandHandler = new HashMap<String, Handler>();
        commandHandler.put("showStudents", new StudentsHandler());
        commandHandler.put("displayClasses", new ClassesHandler());
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
