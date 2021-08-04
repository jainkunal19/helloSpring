package com.jain.helloSpring.repositories;



import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jain.helloSpring.models.KeyNotFoundException;
import com.jain.helloSpring.models.Person;
import com.jain.helloSpring.models.PersonKey;

@Repository("SQLRepo")
public class SQLRepo implements IRepo {
	@Autowired
	IJpaRepository repo;
	@Override
	public Person select(PersonKey key) throws KeyNotFoundException {
		// TODO Auto-generated method stub
		
		try {
			Person person = repo.findById(key).get();
			return person;
			}
		catch(Exception ex) {
			throw new KeyNotFoundException();
		}
		
	}
	@Override
	public String upsert(PersonKey key, Person person) {
		// TODO Auto-generated method stub
		if (repo.save(person) != null) {
			return ("Data is successfully inserted/updated");
		} else {
			return ("Data is not successfully inserted");
		}
		
	}

	

}
