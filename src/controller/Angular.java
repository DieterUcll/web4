package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Angular extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // fake json (should be replaced by making json of current status of stub or db)
        // { \"id\": 3, \"name\": \"Greetje Jongen\" }
//        String users = "[" +
//                "{ \"firstName\": \"Rudi\", \"lastName\": \"Swennen\", \"userId\": \"ruddy.swennen@ucll.be\", \"status\": \"offline\"}, "+
//                "{ \"firstName\": \"Elke\", \"lastName\": \"Steegmans\", \"userId\": \"elke.steegman@ucll.be\", \"status\": \"offline\"}" +
//                "]";


        List<Person> temp = new ArrayList<>(getPersonService().getPersons());

        //bloop blap
        ObjectMapper mapper = new ObjectMapper();

        // setting the response type to json
        response.setContentType("application/json");

        //convert list en write to response
        String json = mapper.writeValueAsString(temp);
        // setting the CORS request, CrossOriginResourceSharing
        // so that this url/response is accessible in another domain (angular application for example)
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.getWriter().write(json);
    }
}
