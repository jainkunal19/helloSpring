package com.jain.helloSpring.repositories;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jain.helloSpring.models.KeyNotFoundException;
import com.jain.helloSpring.models.Person;
import com.jain.helloSpring.models.PersonKey;

@Repository("LocalRepo")
public class LocalRepo implements IRepo {
	
	private static Map<String, Person> repo = new ConcurrentHashMap<String, Person>();
	
	@Override
	public Person select(PersonKey key) throws KeyNotFoundException {
		String keystr = key.toString();
		if (!repo.containsKey(keystr)){
			throw new KeyNotFoundException();
		
		}
		Person person = repo.get(keystr);
		return person;
		
	}
	
	@Override
	public String upsert(PersonKey key, Person person) {
		String keystr = key.toString();
		if (repo.put(keystr, person) == null) {
			return ("key is successfully inserted");
		} else {
			return ("key is successfully updated");
		}
		
		
	}
	
	

}
