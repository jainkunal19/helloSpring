package com.jain.helloSpring.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import com.jain.helloSpring.models.KeyNotFoundException;
import com.jain.helloSpring.models.Person;
import com.jain.helloSpring.models.PersonKey;
import com.jain.helloSpring.repositories.IRepo;
import com.jain.helloSpring.repositories.RepoFactory;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	@Mock
	private RepoFactory repo;
	
	@Mock
	private IRepo repo1;
	
	@InjectMocks
	private PersonService service;
	
	@Test
	public void givenaPerson_whenPutPersonisCalled_thenReturnSuccess() {
		Person person = new Person();
		
		when(repo.getRepo(anyString())).thenReturn(repo1);
			when(repo1.upsert(any(PersonKey.class), any(Person.class))).thenReturn("Person successfully Inserted");
		String returnStr = service.putPerson(person, "redisrepo");
		assertThat(returnStr).isEqualTo("Person successfully Inserted");
	}

	@Test
	public void givenPersonKeys_whengetPersonCalled_thenReturnPersons() throws KeyNotFoundException {
		List<PersonKey> keys = new ArrayList<PersonKey>();
		PersonKey key = new PersonKey();
		keys.add(key);
		
		Person person = new Person();
		
		when(repo.getRepo(anyString())).thenReturn(repo1);
			when(repo1.select(any(PersonKey.class))).thenReturn(person);
		List<Person> returnStr = service.getPerson(keys, "redisrepo");
		assertThat(returnStr).isNotNull();
	}
	
	@Test
	public void givenPersonKeys_whengetPersonCalled_thenThrowException() throws KeyNotFoundException  {
		List<PersonKey> keys = new ArrayList<PersonKey>();
		PersonKey key = new PersonKey();
		keys.add(key);
		
		
		
		when(repo.getRepo(anyString())).thenReturn(repo1);
			when(repo1.select(any(PersonKey.class))).thenThrow(new KeyNotFoundException());
		
			List<Person> returnStr = null;
			try {
				returnStr = service.getPerson(keys, "redisrepo");
			} catch (KeyNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				
			}
			assertThat(returnStr).isNull();
	}
	

}
