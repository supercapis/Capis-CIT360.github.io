package controller.handlers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.HashMap;
import model.CityStateModel;


import javax.ws.rs.core.UriBuilder;

/***
 *
 * This is a handler made for any City State Lookup
 *
 * This class is an implementation of Handler Interface and it is contracted to use the method handleit() receiving a hashmap
 * object with data to be processed.
 *
 */
public class CityStateHandler implements Handler{
    /**
     * 
     * @param data
     * @return Object Object
     */
    @Override
    public Object handleIt(HashMap<String, Object> data) { 
        CityStateModel requestModel = this.fillObjectModelRequest(data);
        Object object = this.sendCityStateHttpRequest(requestModel);
        return object;
    }
    
    
    private Object sendCityStateHttpRequest(CityStateModel requestModel){
        String  jsonResponse = null;
        try {
            URI zipCodeUri = UriBuilder.fromUri(URL_CITY_STATE_LOOKUP).queryParam("zipcode", requestModel.getZipCode()).build();
            jsonResponse = this.sendHttpGet(zipCodeUri).body(); 
        } catch(IOException | InterruptedException e){
            e.printStackTrace();
        } 
        return jsonResponse;
    }
    
     private HttpResponse<String> sendHttpGet(URI httpUrlParameters) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(httpUrlParameters).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }
    
    private CityStateModel fillObjectModelRequest(HashMap<String, Object> data){
         CityStateModel model = new CityStateModel();
         model.setZipCode(data.get("zipCode").toString());
        return model;
    }
 
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
    
    /**
     * Local Server test URL
     */
    private static final String URL_CITY_STATE_LOOKUP = "http://localhost:8080/web_war_exploded/cityStateLookUp";
    
}
