package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.library.entity.Employee;
import com.library.persistence.LibraryDao;

@Service
public class EmployeeLibraryServiceImpl implements EmployeeLibraryService {

	@Autowired
	LibraryDao libraryDao;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Employee login(String email, String password) {
		try {
			Employee emp = restTemplate.getForObject("http://localhost:8080/employee/" + email + "/" + password,
					Employee.class);
			if (emp != null)
				return emp;
		} catch (Exception ex) {
			return null;
		}
		return null;
	}

	@Override
	public Employee register(String first_name, String last_name, String email, String password) {
		try {
			Employee newEmpAccount = new Employee();

			newEmpAccount.setFirst_name(first_name);
			newEmpAccount.setLast_name(last_name);
			newEmpAccount.setEmail(email);
			newEmpAccount.setPassword(password);

			String postNewEmp = restTemplate.postForObject("http://localhost:8080/" + newEmpAccount, newEmpAccount,
					String.class);

			if (postNewEmp.equals("Employee Added")) {
				return newEmpAccount;
			}

		} catch (Exception ex) {
			return null;
		}
		return null;
	}

}
