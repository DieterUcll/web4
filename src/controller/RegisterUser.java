package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterUser extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userId = request.getParameter("email");
        String firstname = request.getParameter("lastname");
        String lastname = request.getParameter("firstname");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        System.out.println(userId + firstname + lastname + gender + password + repassword);
        response.sendRedirect("Controller?action=ShowHome");
    }
}
