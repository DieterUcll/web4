package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeStatus extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Person p = (Person) request.getSession().getAttribute("user");

        String status = request.getParameter("status");

        p.setStatus(status);
        getPersonService().updatePersons(p);
        System.out.println(getPersonService().getPerson(p.getUserId()).getStatus());
        request.getSession().setAttribute("status", status);
        response.getWriter().write(getPersonService().getPerson(p.getUserId()).getStatus());

    }
}
