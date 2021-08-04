package com.jain.helloSpring.services;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("Service")
public class Myservice implements IService {
	
	private static final Logger log = LoggerFactory.getLogger(Myservice.class);
	@Value("${spring.application.name}")
	String app;
	@Override
	public String hello(String name) {
		
		
		log.info("The name is " + name);
		log.info("app name is " + app);
		return "Hello " + name;
	}

}
