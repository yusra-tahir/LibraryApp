package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.persistence.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee employeeLogin(String email, String password) {
		try {
			Employee emp = employeeDao.findByEmailAndPassword(email, password);
			if (emp != null)
				return emp;
			return null;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public boolean employeeRegister(Employee emp) {
		try {
			if (employeeDao.save(emp) == null)
				return false;
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
