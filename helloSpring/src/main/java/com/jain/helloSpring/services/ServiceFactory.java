package com.jain.helloSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceFactory {
	@Autowired
	@Qualifier("Service")
	private IService service1;
	
	@Autowired
	@Qualifier("NewService")
	private IService service2;
	
	public IService getService(int num) {
		
		if (num % 2 == 0) {
			return service1;
		} else {
			return service2;
		}
		
	}

}
