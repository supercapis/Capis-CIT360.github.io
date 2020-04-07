package controller.handlers.multithread;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import model.ListModel;


/**
 *
 * Runnable Class used as a Thread
 */
public class RunnableThreadClass implements Runnable{
    
    private String threadName;
    private Thread myRunnableThread;
    private List<String> zipCodeList;
    private ConcurrentHashMap<String, Object> concurrentResults = new ConcurrentHashMap<String, Object>();
    private String zipcode;
    private ListModel listModel;

    public ConcurrentHashMap<String, Object> getConcurrentResults() {
        return concurrentResults;
    }

    public RunnableThreadClass(String zipCode, String threadName, ListModel listModel) {
          this.threadName = threadName;
          this.zipcode = zipCode;
          this.listModel = listModel;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread: " + threadName + " executing");
            RequestClass requestClass = new RequestClass();
            Object response = requestClass.sendCityStateHttpRequest(zipcode);
            listModel.add(response);
        } catch (Exception e) {
        }
    }
 
     public void startThread(){
        System.out.println("Starting " +  threadName );
        if (myRunnableThread == null) {
            myRunnableThread = new Thread (this, threadName);
            myRunnableThread.start();
        }

    }
}
