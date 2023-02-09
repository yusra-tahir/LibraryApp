package com.library.service;

import com.library.entity.Employee;

public interface EmployeeLibraryService {

	/* == LOGIN == */
	
	Employee login(String email, String password);

	/* == REGISTER == */
	
	Employee register(String first_name, String last_name, String email, String password);
	
}
