package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetFriends extends RequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //Get current user from session and put his friends in an list
        Person p = (Person) request.getSession().getAttribute("user");
        List<Person> temp = new ArrayList<>(p.getFriends());

        //bloop blap
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        //convert list en write to response
        String json = mapper.writeValueAsString(temp);
        response.getWriter().write(json);
    }

}
