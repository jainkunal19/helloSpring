package com.jain.helloSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.jain.helloSpring.services.ServiceFactory;

@RestController
public class DemoController {
	@Autowired
	ServiceFactory serviceFactory;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String Hello() {
		return "Hello World!";
		
		
	}

	@RequestMapping(value = "/yourname",  method = RequestMethod.GET)
	String Hello(@RequestParam String name, @RequestParam int num) {
		return serviceFactory.getService(num).hello(name);
		
		
	}
}
