package com.jain.helloSpring.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jain.helloSpring.models.KeyNotFoundException;
import com.jain.helloSpring.models.Person;
import com.jain.helloSpring.models.PersonKey;
import com.jain.helloSpring.services.IPersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Person API", description = "This is a set of API for dealing with persons")
public class PersonController {
	@Autowired
	private IPersonService pservice;
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	
	@ApiOperation(value = "Get the list of persons", response = Person.class)
	@RequestMapping(value = "/getpersons", method = RequestMethod.POST, produces = "Application/Json")
	public ResponseEntity<?> getPerson(@RequestBody List<PersonKey> keys, @RequestHeader(name = "dbtype") String dbtype ) throws KeyNotFoundException {
			
			
			String identifier = dbtype;
			logger.info("db type is " + identifier);
			return new ResponseEntity<List<Person>>(pservice.getPerson(keys, identifier), HttpStatus.FOUND);
		
		
		
	}
	@ApiOperation(value = "Insert/Upsert a person", response = String.class)
	@RequestMapping(value = "/putperson", method = RequestMethod.POST, produces = "Application/Json")
	public ResponseEntity<String> putPerson(@RequestBody Person person, @RequestHeader(name = "dbtype") String dbtype ) {
		String identifier = dbtype;
		return new ResponseEntity<String>(pservice.putPerson(person, identifier), HttpStatus.CREATED);
		
		
	}
}
