package service;

import entity.RequestResponseModelProcessor;
import entity.USPSRequestResponse;
import org.json.JSONObject;
import org.json.XML;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Service class responsible to handle all processing requests.
 *
 */
public class USPSService {

    /**
     * Connection URL for USPS
     */
    private static final String URL_CITYSTAKELOOKUP_BY_ZIP = "https://secure.shippingapis.com/ShippingAPI.dll?API=CityStateLookup";
    private static final String URL_ZIPCODELOOKUP_BY_ADDRESS = "https://secure.shippingapis.com/ShippingAPI.dll?API=ZipCodeLookup";
    /**
     * Json Prettify factor
     */
    private static int PRETTY_PRINT_INDENT_FACTOR = 4;
    /**
     * Client for HTTP requests
     */
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    /**
     * Sample:
     * <ZipCodeLookupRequest USERID="XXXXXXXXXXXX">
     * <Address ID="1">
     * <Address1></Address1>
     * <Address2>8 Wildwood Drive</Address2>
     * <City>Old Lyme</City>
     * <State>CT</State>
     * <Zip5>06371</Zip5>
     * <Zip4></Zip4>
     * </Address>
     * </ZipCodeLookupRequest>
     *
     * Public service method for getting information from DB
     *
     * @param address
     * @param city
     * @param state
     * @param zipCode
     * @return
     */
    public String retrieveZipCodeByAddress(String address, String city, String state, String zipCode) {

        USPSRequestResponse uspsRequestResponse =  this.getAddressAlreadyProcessed(address, city, state, zipCode, "ZipCodeLookupRequest");
        if (uspsRequestResponse.getCityResponse() != null){
            return uspsRequestResponse.getJsonResponse();
        }

        String xmlResponse = "";
        try {
            String xml =
                    "<ZipCodeLookupRequest USERID=\"694STUDE1753\">"
                            + "<Address ID=\"1\">"
                            + "<Address1></Address1>"
                            + "<Address2>" + address + "</Address2>"
                            + "<City>" + city + "</City>"
                            + "<State>" + state + "</State>"
                            + "<Zip5>" + zipCode + "</Zip5>"
                            + "<Zip4></Zip4>"
                            + "</Address>"
                            + "</ZipCodeLookupRequest>";
            URI zipCodeUri = UriBuilder.fromUri(URL_ZIPCODELOOKUP_BY_ADDRESS).queryParam("XML", xml).build();
            xmlResponse = this.sendHttpGet(zipCodeUri).body();
            JSONObject jsonResponse = this.xmlToJsonObject(xmlResponse);
            //Prettify Json response
            xmlResponse = this.xmlToJsonString(jsonResponse);
            //Call entity model to save request and response
            RequestResponseModelProcessor responseModelProcessor = new RequestResponseModelProcessor();
            responseModelProcessor.saveRequestResponse(jsonResponse, xmlResponse, address, "ZipCodeLookupRequest");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return xmlResponse;
    }



    /**
     * Sample:
     * <CityStateLookupRequest USERID="XXXXXXXXXXXX">
     * <ZipCode ID='0'>
     * <Zip5>20024</Zip5>
     * </ZipCode>
     * </CityStateLookupRequest>
     *
     * Public service method for getting information from DB
     *
     * @param zipCode
     * @return
     */
    public String retrieveCityStateByZipCode(String zipCode) {

        USPSRequestResponse uspsRequestResponse =  this.getZipCodesAlreadyProcessed(zipCode, "CityStateLookupRequest");
        if (uspsRequestResponse.getCityResponse() != null){
            return uspsRequestResponse.getJsonResponse();
        }

        String xmlResponse = "";
        try {
            String xml =
                    "<CityStateLookupRequest USERID=\"694STUDE1753\">"
                            + "<ZipCode ID=\"0\">"
                            + "<Zip5>" + zipCode + "</Zip5>"
                            + "</ZipCode>"
                            + "</CityStateLookupRequest>";
            URI zipCodeUri = UriBuilder.fromUri(URL_CITYSTAKELOOKUP_BY_ZIP).queryParam("XML", xml).build();
            xmlResponse = this.sendHttpGet(zipCodeUri).body();
            JSONObject jsonResponse = this.xmlToJsonObject(xmlResponse);

            //Call entity model to save request and response
            RequestResponseModelProcessor responseModelProcessor = new RequestResponseModelProcessor();
            //Prettify Json response
            xmlResponse = this.xmlToJsonString(jsonResponse);
            responseModelProcessor.saveRequestResponse(jsonResponse, xmlResponse, null,"CityStateLookupRequest");


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return xmlResponse;
    }

    /**
     * Checks DB for previous inserted data (address)
     * @param address
     * @param city
     * @param state
     * @param zipCode
     * @param requestType
     * @return
     */
    private USPSRequestResponse getAddressAlreadyProcessed(String address, String city, String state, String zipCode, String requestType) {
        RequestResponseModelProcessor modelProcessor = new RequestResponseModelProcessor();
        USPSRequestResponse requestResponse = modelProcessor.getAddressProcessedInDB(address, city, state, zipCode, requestType);
        return requestResponse;
    }

    /**
     * Check DB for previous inserted data (zipcode)
     * @param zipCode
     * @param requestType
     * @return
     */
    private USPSRequestResponse getZipCodesAlreadyProcessed(String zipCode, String requestType) {
        RequestResponseModelProcessor modelProcessor = new RequestResponseModelProcessor();
        USPSRequestResponse requestResponse = modelProcessor.getZipCodesAlreadyProcessedInDB(zipCode, requestType);
        return requestResponse;
    }

    /**
     * Performs the HTTP request to an external server
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
     * Helper method - String XML to Json
     * @param xml
     * @return
     */
    private JSONObject xmlToJsonObject(String xml) {
        JSONObject transformedJson = XML.toJSONObject(xml);
        return transformedJson;
    }

    /**
     * Helper method - Json Object to Prettified Json String
     * @param json
     * @return
     */
    private String xmlToJsonString(JSONObject json) {
        String prettyJsonString = json.toString(PRETTY_PRINT_INDENT_FACTOR);
        return prettyJsonString;
    }

}
