/*JSON is a technology in a simple format based on text,
that allows communication of objects between platforms*/

/*This program is to show the two parts process:
 * 1 - Pick an object and transform it to JSON
 * 2 - Pick it back and transform it to an object
 *
 * It will exhibit 4 pieces of my car's information*/

/*Importing parsers - core, databind and annotation from the library*/

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/*Class JSON comprising two static statements and the main statement*/
class JSON {

    /*Transforming the object to JSON */
    public static String ObjectToJSON(Car myCar) {

        ObjectMapper mapper = new ObjectMapper();
        String string = "";
        /*Method to capture errors and exceptions in the program*/
        try {
            string = mapper.writeValueAsString(myCar);
        } catch (JsonProcessingException e) {
            System.err.println(e.toString());
        }

        return string;
    }

    /*Now, transforming the JSON to object*/
    public static Car JSONToObject(String s) {

        ObjectMapper mapper = new ObjectMapper();
        Car car = null;
        /*Method to capture errors and exceptions in the program*/
        try {
            car = mapper.readValue(s, Car.class);
        } catch (JsonProcessingException e) {
            System.err.println(e.toString());
        } catch (IOException e) {
            System.err.println(e.toString());
        }

        return car;
    }

    /*Main statement with the information I want to be printed*/
    public static void main(String[] args) {

        /*Creating instances for the car object*/
        Car carTojson = new Car();
        carTojson.setBrand("Volvo");
        carTojson.setYear(2008);
        carTojson.setModel("Sedan");
        carTojson.setColor("Gray");
        /*Converting the object to a string in JSON format*/
        String json = JSON.ObjectToJSON(carTojson);
        System.out.println(json);
        /*Converting the JSON format to an object*/
        Car carFromjson = JSON.JSONToObject(json);
        System.out.println(carFromjson);
        /*All the credits to Troy Tuckett Instruction*/
    }
}