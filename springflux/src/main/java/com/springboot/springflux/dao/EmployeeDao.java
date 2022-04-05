package com.springboot.springflux.dao;

import java.time.Duration;

import org.springframework.stereotype.Repository;

import com.springboot.springflux.model.Employee;

import reactor.core.publisher.Flux;

@Repository
public class EmployeeDao {

	public Flux<Employee> getEmployees(){
		return Flux.range(1, 10).delayElements(Duration.ofMillis(1000)).map(o -> new Employee(o, "Employee"));
	}
}
