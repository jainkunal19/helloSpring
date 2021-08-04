package com.jain.helloSpring.services;

import java.util.List;

import com.jain.helloSpring.models.KeyNotFoundException;
import com.jain.helloSpring.models.Person;
import com.jain.helloSpring.models.PersonKey;

public interface IPersonService {

	List<Person> getPerson(List<PersonKey> keys, String identifier) throws KeyNotFoundException;

	String putPerson(Person p, String identifier);

}