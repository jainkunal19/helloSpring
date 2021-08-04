package com.jain.helloSpring.repositories;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jain.helloSpring.models.KeyNotFoundException;
import com.jain.helloSpring.models.Person;
import com.jain.helloSpring.models.PersonKey;

@Repository("RedisRepo")
public class RedisRepo implements IRepo {
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, PersonKey, Person> hashOperations;
	
    @PostConstruct
    private void intializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }
    
    @Override
	public Person select(PersonKey key) throws KeyNotFoundException {
		// TODO Auto-generated method stub
    	Person person = hashOperations.get("persons", key);
		if (person != null) {
			return person;
		}else {
			throw new KeyNotFoundException();
		}
	}

	@Override
	public String upsert(PersonKey key, Person person) {
		// TODO Auto-generated method stub
		hashOperations.put("persons", key, person);
		return "Inserted successfully";
	}

}
