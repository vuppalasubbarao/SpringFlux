package com.springboot.springflux.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.springboot.springflux.handler.EmployeeHandler;

@Configuration
public class RouterConfiguration {

	@Autowired
	public EmployeeHandler handler;
	
	@Bean
	public RouterFunction<ServerResponse> routerFunction(){
		return RouterFunctions.route().GET("/EmployeeList", handler::getEmployees).build();
	}
}
