package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AngularPost extends RequestHandler{
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");


        //ontvangen van data uit angular app
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addKeyDeserializer(Person.class, new YourClassKeyDeserializer());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(simpleModule);
        Person person = objectMapper.readValue(request.getInputStream(), Person.class);
        System.out.println(person.getFirstName() + " " + person.getLastName() + " " + person.getUserId() + person.getGender());

    }
}

class YourClassKeyDeserializer extends KeyDeserializer
{
    @Override
    public Object deserializeKey(final String key, final DeserializationContext ctxt ) throws IOException, JsonProcessingException
    {
        return null; // replace null with your logic
    }
}
