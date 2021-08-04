package com.jain.helloSpring.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jain.helloSpring.services.PersonControllerInterceptor;

 @Component
public class PersonControllerInterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	PersonControllerInterceptor pcinterceptor;

	
	public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(pcinterceptor);
	   }
}
