package controller.handlers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import javax.ws.rs.core.UriBuilder;
import model.AddressModel;

/**
 * Address Handler implementing interface Handler 
 */
public class AddressHandler implements Handler{

    @Override
    public Object handleIt(HashMap<String, Object> data) {
        AddressModel requestModel = this.fillObjectModelRequest(data);
        Object object = this.sendCityStateHttpRequest(requestModel);
        return object;
    }
    
    /**
     * sends a HTTP request to an external server
     * @param requestModel
     * @return 
     */
    private Object sendCityStateHttpRequest(AddressModel requestModel){
        String  jsonResponse = null;
        try {
            URI zipCodeUri = UriBuilder.fromUri(URL_ADDRESS_LOOKUP)
                    .queryParam("Zip", requestModel.getZipcode())
                    .queryParam("Address", requestModel.getAddress())
                    .queryParam("City", requestModel.getCity())
                    .queryParam("State", requestModel.getState()).build();
            jsonResponse = this.sendHttpGet(zipCodeUri).body(); 
        } catch(IOException | InterruptedException e){
            e.printStackTrace();
        } 
        return jsonResponse;
    }
    
    /**
     * Performs HTTP GET
     * 
     * @param httpUrlParameters
     * @return
     * @throws IOException
     * @throws InterruptedException 
     */
     private HttpResponse<String> sendHttpGet(URI httpUrlParameters) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(httpUrlParameters).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }
    
     /**
      * Prepares a model object to send in the request
      * @param data
      * @return 
      */
    private AddressModel fillObjectModelRequest(HashMap<String, Object> data){
         AddressModel model = new AddressModel();
         model.setZipcode(data.get("zipCode").toString());
         model.setCity(data.get("city").toString());
         model.setAddress(data.get("address").toString());
         model.setState(data.get("state").toString());
        return model;
    }
 
    /**
     * HTTP client for the request
     */
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
    
    /**
     * Local Server test URL
     */
    private static final String URL_ADDRESS_LOOKUP = "http://localhost:8080/web_war_exploded/zipCodeLookUp";
}
