package com.employee.service;

import com.employee.entity.Employee;

public interface EmployeeService {
	
	Employee employeeLogin(String email, String password);
	
	boolean employeeRegister(Employee employee);
	
}
