package com.springboot.springflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.springboot.springflux.dao.EmployeeDao;
import com.springboot.springflux.model.Employee;

import reactor.core.publisher.Mono;

@Service
public class EmployeeHandler {

	
	@Autowired
	public EmployeeDao dao;
	
	public Mono<ServerResponse> getEmployees(ServerRequest serverRequest){
		System.out.println("Router functioality is working");
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(dao.getEmployees(),Employee.class);
	}
}
