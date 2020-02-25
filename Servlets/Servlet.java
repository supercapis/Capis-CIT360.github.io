/**
 * Java servlets typically run on the HTTP protocol.
 * The client sends a request message to the server, and the server returns a response message.
 * **/
package ServletExample;
/*Some packets were imported after the Servlet creation*/
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Explanation: a validation is performed in the input fields of the jsp file.
 * When a request is made by the user, the servlet retrieves the information through the request.
 * To be able to retrieve the information that is passed in the input fields,
 * it is necessary that the name property is defined,
 * and used with the same name in the parameter of the getParameter () method.
 * **/
@WebServlet(name = "LoginInfo", urlPatterns = {"/LoginInfo"})
public class Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Servlet(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("name");
        String pass = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = null;
        request.setAttribute(id, "name");
        /**
         * If boolean stating Login and Password info: Username: name ; Password: pass
         * **/
        if(id.equals("name") && pass.equals("pass")){
            out.println("<b>You got the right Login and Password!</b><br>");
            out.println("<br><span>Login: " + id + "</span><br>");
            out.println("<br><span>Password: " + pass + "</span>");
            rd = request.getRequestDispatcher("/LoginInfo.jsp");
            rd.include(request, response);
        }
        /**
         * Else stating the message: "Invalid Login"
         * **/
        else{
            out.println("<b>Invalid Login Info.</b><br>");
            rd = request.getRequestDispatcher("/LoginInfo.jsp");
            rd.include(request, response);
        }
        out.close();

    }
    /**
     * It is important to note that in versions higher than 7 of Tomcat, the mapping is done automatically.
     * **/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
