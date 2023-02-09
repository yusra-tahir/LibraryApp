package com.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor		
@AllArgsConstructor	

public class Employee {
	
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	
}
