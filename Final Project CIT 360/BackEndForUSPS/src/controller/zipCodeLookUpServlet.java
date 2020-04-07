package controller;

import service.USPSService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * zipCodeLookUp controller class
 * URL: /zipCodeLookUp
 * extends HttpServlet
 */
@WebServlet(name="zipCodeLookUp", urlPatterns = "/zipCodeLookUp")
public class zipCodeLookUpServlet extends HttpServlet {

    /**
     * Service to process servlet requests
     */
    private final USPSService uspsService = new USPSService();

    /**
     * Post Method inherited from HttpServlet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.processRequest(request, response);
    }

    /**
     * GET Method inherited from HttpServlet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.processRequest(request, response);
    }

    /**
     * Proccess both Get and Post requests Calling the service class and returning a Json Object to clients
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = request.getParameter("Address");
        String city = request.getParameter("City");
        String state = request.getParameter("State");
        String zipCode = request.getParameter("Zip");

        USPSService uspsService = new USPSService();
        String serviceResponse = uspsService.retrieveZipCodeByAddress(address, city, state, zipCode);

        //add response to ServletResponse
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(serviceResponse);
        out.flush();
    }
}
