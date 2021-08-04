package com.jain.helloSpring.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("NewService")
public class MyNewService implements IService {
	
	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "Whats up " + name;
	}

}
