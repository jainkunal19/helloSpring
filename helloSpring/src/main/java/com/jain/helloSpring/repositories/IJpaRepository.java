package com.jain.helloSpring.repositories;


import org.springframework.data.repository.CrudRepository;

import com.jain.helloSpring.models.Person;
import com.jain.helloSpring.models.PersonKey;

public interface IJpaRepository extends CrudRepository<Person, PersonKey>{

	
	
	
}