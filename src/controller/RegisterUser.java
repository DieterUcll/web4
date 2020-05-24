package controller;

import domain.Person;
import domain.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterUser extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userId = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        int age = Integer.parseInt(request.getParameter("age"));

        if(password.equals(repassword)) {
            Person p = new Person(userId, password, firstname,lastname, Role.LID);
            p.setGender(gender);
            p.setAge(age);
            getPersonService().addPerson(p);
        } else {
            throw new IllegalArgumentException("Password not okey buddy, not matching");
        }


        //test if the user is added to the list
        System.out.println(getPersonService().getPersons());

        response.sendRedirect("Controller?action=ShowHome");
    }
}
