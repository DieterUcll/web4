package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetStatus extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Person user = (Person) request.getSession().getAttribute("user");
        if (user != null) {
            String status = user.getStatus();
            response.setContentType("application/json");
            response.getWriter().write(status);
        }
    }
}
