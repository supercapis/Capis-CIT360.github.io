package controller.handlers;

import controller.handlers.multithread.RunnableThreadClass;
import java.util.HashMap;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.ListModel;

/**
 *
 * Zip code collection handler
 */
public class ZipCodeListHandler implements Handler{
    
     /**
     * Start a multi thread request in the client
     * @param data
     * @return Object Object
     */
    @Override
    public Object handleIt(HashMap<String, Object> data) { 
        List<String> zipList = (List<String>) data.get("zipcodeList");
        ListModel listModel = new ListModel();
        for (int i = 0; i < zipList.size(); i++) {
            RunnableThreadClass threadClass = new RunnableThreadClass(zipList.get(i), "Thread-"+i, listModel );
            threadClass.startThread();   
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ZipCodeListHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listModel.getCityStateModel();
    }
    
}
