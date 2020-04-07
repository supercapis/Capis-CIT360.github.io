package model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * ListModel class used for 
 */
public class ListModel {
    
  private List<Object> cityStateModel = new ArrayList<Object>();

    public List<Object> getCityStateModel() {
        return cityStateModel;
    }
    
  public synchronized void add(Object responseModel){
      cityStateModel.add(responseModel);
  }
  
  
    
}
