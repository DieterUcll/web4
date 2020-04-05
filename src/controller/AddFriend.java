package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddFriend extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Person current = (Person) request.getSession().getAttribute("user");
        System.out.println("before update:" + current.getStatus());
        Person friend = getPersonService().getPerson(request.getParameter("friendId"));
        current.getFriends().add(friend);
        friend.getFriends().add(current);
        getPersonService().updatePersons(current);

        System.out.println("after update:" + getPersonService().getPerson(current.getUserId()).getStatus());
        getPersonService().updatePersons(friend);
        System.out.println(current.getFriends());

    }
}
