package entity;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GenerationType;

/**
 * This is an entity hibernate class that serves as a DB table
 *
 */
@Entity
@Table(name = "USPS_request_response")
public class USPSRequestResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "requestId")
    private Integer requestId;

    @Column(name = "request_type")
    private String requestType;

    @Column(name = "request_address")
    private String requestAddress;

    @Column(name = "zipcode_request")
    private Integer zipCodeRequest;

    @Column(name = "city_request")
    private String cityRequest;

    @Column(name = "state_request")
    private String stateRequest;

    @Column(name = "zipcode_response")
    private Integer zipcodeResponse;

    @Column(name = "zipcode_response_Complement")
    private Integer zipcodeComplementResponse;

    @Column(name = "city_response")
    private String cityResponse;

    @Column(name = "address_response")
    private String addressResponse;

    @Column(name = "state_response")
    private String stateResponse;

    @Column(name = "fullJson_response")
    private String jsonResponse;


    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getZipCodeRequest() {
        return zipCodeRequest;
    }

    public void setZipCodeRequest(Integer zipCodeRequest) {
        this.zipCodeRequest = zipCodeRequest;
    }

    public String getCityRequest() {
        return cityRequest;
    }

    public void setCityRequest(String cityRequest) {
        this.cityRequest = cityRequest;
    }

    public String getStateRequest() {
        return stateRequest;
    }

    public void setStateRequest(String stateRequest) {
        this.stateRequest = stateRequest;
    }

    public Integer getZipcodeResponse() {
        return zipcodeResponse;
    }

    public void setZipcodeResponse(Integer zipcodeResponse) {
        this.zipcodeResponse = zipcodeResponse;
    }

    public String getCityResponse() {
        return cityResponse;
    }

    public void setCityResponse(String cityResponse) {
        this.cityResponse = cityResponse;
    }

    public String getStateResponse() {
        return stateResponse;
    }

    public void setStateResponse(String stateResponse) {
        this.stateResponse = stateResponse;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestAddress() {
        return requestAddress;
    }

    public void setRequestAddress(String requestAddress) {
        this.requestAddress = requestAddress;
    }

    public Integer getZipcodeComplementResponse() {
        return zipcodeComplementResponse;
    }

    public void setZipcodeComplementResponse(Integer zipcodeComplementResponse) {
        this.zipcodeComplementResponse = zipcodeComplementResponse;
    }

    public String getAddressResponse() {
        return addressResponse;
    }

    public void setAddressResponse(String addressResponse) {
        this.addressResponse = addressResponse;
    }

    public String getJsonResponse() {
        return jsonResponse;
    }

    public void setJsonResponse(String jsonResponse) {
        this.jsonResponse = jsonResponse;
    }
}
