/*The purpose of requesting a HTTP/url by using an API link is
to connect one system to another - or even a server*/

/*Generating an API link from a website(server) was part of the process*/

/*Importing these packages to assist in the HTTP requests*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTP {
    public static void main(String[] args) throws IOException {

        System.out.println("\nPerforming a basic HTTP request:\n");

        /*Creating a request with an API link by using GET method
         * Generated API key in http://www.omdbapi.com/ - JSON about Jurassic Park Movie*/

        URL url = new URL("http://www.omdbapi.com/?apikey=80cd52e8&t=Jurassic");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();

        /*Reading the response of the request and placing it in a String*/
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        System.out.println("\nGoodbye!\n");
        in.close();

        /*Closing the connection*/
        con.disconnect();


    }
}
