package controller;

import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

public class ControllerFactory {

	public RequestHandler getHandler(PersonService service, HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		if(action == null) {action="ShowHome";};
		RequestHandler handler = null;
		try {
			Class<?> handlerClass = Class.forName("controller." + action);
			Object handlerObject = handlerClass.getConstructor().newInstance();
			handler = (RequestHandler)handlerObject;
			handler.setModel(service);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			throw  new RuntimeException("The requested page could not be found");
		}
		return handler;
	}


}
