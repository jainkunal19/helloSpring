package com.jain.helloSpring.repositories;

import com.jain.helloSpring.models.KeyNotFoundException;
import com.jain.helloSpring.models.Person;
import com.jain.helloSpring.models.PersonKey;

public interface IRepo {

	Person select(PersonKey key) throws KeyNotFoundException;

	String upsert(PersonKey key, Person person);

}