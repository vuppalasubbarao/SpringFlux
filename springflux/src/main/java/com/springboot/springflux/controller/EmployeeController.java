package com.springboot.springflux.controller;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springflux.dao.EmployeeDao;
import com.springboot.springflux.model.Employee;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/getEmployees")
public class EmployeeController {

	@Autowired
	public EmployeeDao dao;
	
	@GetMapping("/list")
	private List<Employee> getEmployees(){
		
		System.out.println("---------->>entered");
		return IntStream.rangeClosed(1, 10).mapToObj(o -> new Employee(o, "Employee")).collect(Collectors.toList());
		
	}
	
	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	private Flux<Employee> getEmployeesStream(){
		
		System.out.println("---------->>entered");
		return dao.getEmployees();
		
	}
}
