package controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendOneOnOne extends RequestHandler {


    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String receiver = request.getParameter("receiver");
        String sender = request.getParameter("sender");
        String message = request.getParameter( "message");

//        System.out.println(receiver + " " + sender + "  " + message);

        getPersonService().addToConvos(getPersonService().getPerson(sender), getPersonService().getPerson(receiver), message);
        getPersonService().addToConvos(getPersonService().getPerson(receiver), getPersonService().getPerson(sender), message);

        System.out.println(getPersonService().getPerson(receiver).getConvos().values());
        response.setContentType("text/plain");
        response.getWriter().write(sender + "(you) : " + message);
    }
}
