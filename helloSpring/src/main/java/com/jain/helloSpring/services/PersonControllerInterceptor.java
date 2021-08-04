package com.jain.helloSpring.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class PersonControllerInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String URL = request.getRequestURI();
		String requestMethod = request.getMethod();
		String ContextId = request.getHeader("correlationId");
		request.setAttribute("correlationId", ContextId);
		if (null == ContextId) {
			request.setAttribute("correlationId", "some_context_id");
		}
		response.setHeader("correlationId", (String) request.getAttribute("correlationId"));
		
		System.out.println(URL + " " + requestMethod + " " + ContextId );
		return true;
	}
	
	
	
}
