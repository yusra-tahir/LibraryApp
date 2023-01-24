package com.employee.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeResource {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = "/employee/{email}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee searchByEmailAndPassword(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		return employeeService.employeeLogin(email, password);
	}

	@PostMapping(path = "/newEmployee", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String registerNewEmployee(@RequestBody Employee newEmp) {
		if ((employeeService.employeeRegister(newEmp)))
			return "Employee Added";
		return "Employee Not Added";
	}
}
