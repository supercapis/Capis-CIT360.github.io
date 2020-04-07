

import controller.ApplicationController;
import controller.handlers.multithread.RequestClass;
import java.util.HashMap;

import static org.junit.Assert.*;
import org.junit.Test;



/**
 * 
 * Client All tests
 */
public class ClientTests {
    
    @Test
    public void cityStateRequestTest(){
        RequestClass request = new RequestClass();
        Object response = request.sendCityStateHttpRequest("84088");
        assertNotNull(response);
    }
    
    @Test
    public void checkMapping(){
        ApplicationController applicationController = new ApplicationController();
        HashMap<String, Object> commandData = new HashMap<>();
        String commandKey = "WrongCommand";
        String message = "";
        try {
            Object doCommand = applicationController.doCommand(commandKey, commandData);
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        assertTrue(String.format("There is no Handler mapped for [%s].", commandKey).equals(message));
    }
   
    
    
}
