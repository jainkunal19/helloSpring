package com.jain.helloSpring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.jain.helloSpring.models.KeyNotFoundException;
import com.jain.helloSpring.models.Person;
import com.jain.helloSpring.models.PersonKey;
import com.jain.helloSpring.repositories.IRepo;
import com.jain.helloSpring.repositories.RepoFactory;

@Service
public class PersonService implements IPersonService {
	
	@Autowired
	
	private RepoFactory repofactory ;
	
	@Override
	public List<Person> getPerson(List<PersonKey> keys, String identifier) throws KeyNotFoundException {
		List<Person> persons = new ArrayList<Person>();
		for ( PersonKey key : keys) {
			try {
				persons.add(repofactory.getRepo(identifier).select(key));
			}
			catch (KeyNotFoundException ex) {
				
			}
			
		}
		if (persons.isEmpty()) {
			throw new KeyNotFoundException();
		}
		return persons;
		
	}

	@Override
	public String putPerson(Person p, String identifier) {
		// TODO Auto-generated method stub
		
		PersonKey key = new PersonKey(p.getZip(), p.getName(),p.getDob());
		return repofactory.getRepo(identifier).upsert(key, p);
		
	}

}
