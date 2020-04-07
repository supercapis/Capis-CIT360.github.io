import entity.RequestResponseModelProcessor;
import entity.USPSRequestResponse;
import org.junit.Test;
import service.USPSService;

import static org.junit.Assert.assertNotNull;

/**
 * Unit Test class
 * Testing all public methods available in the Service class
 * and ModelProcessor class
 */
public class UnitTests {

    @Test
    public void zicodeTest(){
        USPSService uspsService = new USPSService();
        String response = uspsService.retrieveCityStateByZipCode("84088");
        assertNotNull(response);
    }
    @Test
    public void addressTest(){
        USPSService uspsService = new USPSService();
        String response = uspsService.retrieveZipCodeByAddress("1332 W Stone Meadow Dr", "West Jordan", "UT", "84088");
        assertNotNull(response);
    }
    @Test
    public void getAddressFromDbTest(){
        RequestResponseModelProcessor responseModelProcessor = new RequestResponseModelProcessor();
        USPSRequestResponse response = responseModelProcessor.getAddressProcessedInDB(
                "1332 W Stone Meadow Dr",
                "West Jordan",
                "UT",
                "84088",
                "ZipCodeLookupRequest");
        assertNotNull(response.getCityResponse());
    }
    @Test
    public void getCityStateFromDbTest(){
        RequestResponseModelProcessor responseModelProcessor = new RequestResponseModelProcessor();
        USPSRequestResponse response = responseModelProcessor.getZipCodesAlreadyProcessedInDB(
                "84088",
                "CityStateLookupRequest");
        assertNotNull(response.getStateResponse());
    }



}
