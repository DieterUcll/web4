package domain;

import java.util.ArrayList;
import java.util.List;

import db.PersonRepository;
import db.PersonRepositoryStub;

public class PersonService {
	private PersonRepository personRepository = new PersonRepositoryStub();

	public PersonService(){
	}
	
	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}


	public void addToConvos(Person sender, Person receiver, String message) {
		List<String> messages = personRepository.get(sender.getUserId()).getConvos().get(receiver);

		// if list does not exist create it
		if(messages == null) {
			messages = new ArrayList<String>();
			messages.add(message);
			sender.getConvos().put(receiver,messages);
		} else {
			// add if item is not already in list
			messages.add(message);
		}
	}
}
