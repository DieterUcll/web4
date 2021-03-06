package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeBackground extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Person p = (Person) request.getSession().getAttribute("user");
        String colorCode = request.getParameter("colorCode");

        p.setBackgroundColor(colorCode);

        System.out.println("colorcode: " + colorCode);


        response.setContentType("text/plain");
        response.getWriter().write(colorCode);
    }
}
