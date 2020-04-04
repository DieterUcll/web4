package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetOneOnOne extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String receiver = request.getParameter("receiver");

        Person sender = (Person) request.getSession().getAttribute("user");


        List<String> convos = sender.getConvos().get(getPersonService().getPerson(receiver));
        //bloop blap
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        //convert list en write to response
        String json = mapper.writeValueAsString(convos);
        response.getWriter().write(json);
    }
}
