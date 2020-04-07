package controller.handlers.multithread;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.ws.rs.core.UriBuilder;

/**
 * A request class for the use of multiThreads
 *
 */
public class RequestClass {
    
    /**
     * Send HTTP Request
     * @param zipcode
     * @return 
     */
    public Object sendCityStateHttpRequest(String zipcode){
        String  jsonResponse = null;
        try {
            URI zipCodeUri = UriBuilder.fromUri(URL_CITY_STATE_LOOKUP).queryParam("zipcode", zipcode).build();
            jsonResponse = this.sendHttpGet(zipCodeUri).body(); 
        } catch(IOException | InterruptedException e){
            e.printStackTrace();
        } 
        return jsonResponse;
    }
    
    /**
     * Send GET 
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
  * HTTP Client
  */
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
    
    /**
     * Local Server test URL
     */
    private static final String URL_CITY_STATE_LOOKUP = "http://localhost:8080/web_war_exploded/cityStateLookUp";
    
    
    
    
}
