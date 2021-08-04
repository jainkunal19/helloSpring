package com.jain.helloSpring.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class RepoFactory {
	@Autowired
	@Qualifier("RedisRepo")
	private IRepo redisRepo;
	
	@Autowired
	@Qualifier("SQLRepo")
	private IRepo sqlRepo;
	
	@Autowired
	@Qualifier("LocalRepo")
	private IRepo localRepo;
	
	public IRepo getRepo(String identifier) {
		if (identifier.equalsIgnoreCase("RedisRepo")) {
			return redisRepo;
		} else if (identifier.equalsIgnoreCase("SQLRepo")) {
			return sqlRepo;
		} else {
			return localRepo;
		}
	}
}
