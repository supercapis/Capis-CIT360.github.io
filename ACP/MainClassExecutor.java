import ACP.ApplicationController;

import java.util.HashMap;

/**
  * 1) MainClassExecutor calls for an Application Controller to process data in specific Handlers
 * 2) Application Controller Implements a map of all handlers available in the application.
 * 3) Every Handler Implements a Handler interface which contracts for a handleit() method
 * 4) Application Controller checks for requested handlers that are not mapped and inform the executor which prints the error message
 * 5) Each handler performs a different operation
 *
 */
public class MainClassExecutor {


    public static void main(String[] args) {
        ApplicationController controller = new ApplicationController();

        //This object holds all values
        HashMap<String, Object> hashMapData = new HashMap<String, Object>();

        try{
            /**
             * 1) Code below targets StudentHandler.java which is mapped in the Application Controller as "showStudents"
             */
            System.out.println("\nStudent Handler processed:");
            controller.doCommand("showStudents", hashMapData);

            /**
             * 2) Code below targets ClassesHandler.java which is mapped in the Application Controller as "displayClasses"
             */
            System.out.println("\nClasses Handler processed:");
            controller.doCommand("displayClasses", hashMapData);

            /**
             * 3) Code below shows what happens when the handler targeted is not mapped in the Application Controller
             */
            System.out.println("\nThis is a NOT FOUND handler example - There is no handler mapped for the command provided:");
            controller.doCommand("NonExistentHandler", hashMapData);

        } catch (Exception e){
            //it shows a message made by the controller in case an nonexistent handler is called.
            System.out.println(e.getMessage());
        }
    }

}
