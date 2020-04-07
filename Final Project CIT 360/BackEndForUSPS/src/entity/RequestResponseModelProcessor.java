package entity;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.json.JSONObject;

import java.util.List;

/**
 * Database Processor.
 * Receives all DB related calls
 */
public class RequestResponseModelProcessor {


    /**
     * Save Response Requests to database
     * @param responseObj
     * @param xmlResponse
     * @param address
     * @param type
     */
    public void saveRequestResponse(JSONObject responseObj, String xmlResponse, String address, String type){
        USPSRequestResponse uspsRequestResponse = this.prepareObject(responseObj, xmlResponse, address, type);
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(uspsRequestResponse);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Lookup DB for previous inserted zipcode information
     * @param zipCode
     * @param requestType
     * @return
     */
    public USPSRequestResponse getZipCodesAlreadyProcessedInDB(String zipCode, String requestType) {
        Session session = HibernateSession.getSessionFactory().openSession();
        NativeQuery query =  session.createNativeQuery(SELECT_STATEMENT_ZIPCODE);
        query.setParameter("requestType", requestType );
        query.setParameter("zipcodeRequest", zipCode );
        query.addEntity(USPSRequestResponse.class);
        USPSRequestResponse uspsRequestResponse = new USPSRequestResponse();
        List<USPSRequestResponse> zipcodeList = query.getResultList();
        if (!zipcodeList.isEmpty()){
            uspsRequestResponse =  zipcodeList.get(0);
        }
        return uspsRequestResponse;
    }

    /**
     * Checks database for previous insert complete address information
     * @param address
     * @param city
     * @param state
     * @param zipCode
     * @param requestType
     * @return
     */
    public USPSRequestResponse getAddressProcessedInDB(String address, String city, String state, String zipCode, String requestType) {
        Session session = HibernateSession.getSessionFactory().openSession();
        NativeQuery query =  session.createNativeQuery(SELECT_STATEMENT_ADDRESS);
        query.setParameter("cityRequest", city);
        query.setParameter("requestAddress", address);
        query.setParameter("requestType", requestType);
        query.setParameter("stateRequest", state);
        query.setParameter("zipcodeRequest", zipCode);
        query.addEntity(USPSRequestResponse.class);
        USPSRequestResponse uspsRequestResponse = new USPSRequestResponse();
        List<USPSRequestResponse> zipcodeList = query.getResultList();
        if (!zipcodeList.isEmpty()){
            uspsRequestResponse =  zipcodeList.get(0);
        }
        return uspsRequestResponse;
    }

    /**
     * A helper method to prepare objects to be inserted into the database
     * @param response
     * @param xmlResponse
     * @param type
     * @return
     */
    private USPSRequestResponse prepareObject(JSONObject response, String xmlResponse, String requestAddress, String type){
        USPSRequestResponse preparedObj = new USPSRequestResponse();
        switch (type){
            case "CityStateLookupRequest": {
                preparedObj.setStateResponse(response.getJSONObject("CityStateLookupResponse").getJSONObject("ZipCode").getString("State"));
                preparedObj.setCityResponse(response.getJSONObject("CityStateLookupResponse").getJSONObject("ZipCode").getString("City"));
                preparedObj.setZipCodeRequest(response.getJSONObject("CityStateLookupResponse").getJSONObject("ZipCode").getInt("Zip5"));
                preparedObj.setRequestType(type);
                preparedObj.setJsonResponse(xmlResponse);
                break;
            }
            case "ZipCodeLookupRequest":{
                String state = response.getJSONObject("ZipCodeLookupResponse").getJSONObject("Address").getString("State");
                int zip5 = response.getJSONObject("ZipCodeLookupResponse").getJSONObject("Address").getInt("Zip5");
                String city =  response.getJSONObject("ZipCodeLookupResponse").getJSONObject("Address").getString("City");

                preparedObj.setZipcodeComplementResponse(response.getJSONObject("ZipCodeLookupResponse").getJSONObject("Address").getInt("Zip4"));
                preparedObj.setAddressResponse(response.getJSONObject("ZipCodeLookupResponse").getJSONObject("Address").getString("Address2"));
                preparedObj.setStateRequest(state);
                preparedObj.setZipCodeRequest(zip5);
                preparedObj.setCityRequest(city);
                preparedObj.setRequestAddress(requestAddress);
                preparedObj.setCityResponse(city);
                preparedObj.setStateResponse(state);
                preparedObj.setZipcodeResponse(zip5);
                preparedObj.setRequestType(type);
                preparedObj.setJsonResponse(xmlResponse);
                break;
            }
            default:
                break;
        }
        return preparedObj;
    }

    /**
     * Select statement for zip code lookup
     */
    private static final String SELECT_STATEMENT_ZIPCODE =
            "SELECT " +
                    "requestId, " +
                    "address_response, " +
                    "city_request, " +
                    "city_response, " +
                    "request_address, " +
                    "request_type, " +
                    "state_request,  " +
                    "state_response, " +
                    "zipcode_request, " +
                    "zipcode_response_Complement, " +
                    "zipcode_response, " +
                    "fullJson_response " +
            "FROM " +
                    "usps_request_response " +
            "WHERE "+
                    "request_type = :requestType " +
                    "AND zipcode_request = :zipcodeRequest";

    /**
     * Select statement for complete address lookup
     */
    private static final String SELECT_STATEMENT_ADDRESS =
            "SELECT " +
                    "requestId, " +
                    "address_response, " +
                    "city_request, " +
                    "city_response, " +
                    "request_address, " +
                    "request_type, " +
                    "state_request,  " +
                    "state_response, " +
                    "zipcode_request, " +
                    "zipcode_response_Complement, " +
                    "zipcode_response, " +
                    "fullJson_response " +
            "FROM " +
                    "usps_request_response " +
            "WHERE "+
                    "city_request = :cityRequest " +
                    "AND request_address = :requestAddress " +
                    "AND request_type = :requestType " +
                    "AND state_request = :stateRequest " +
                    "AND zipcode_request = :zipcodeRequest";

}
