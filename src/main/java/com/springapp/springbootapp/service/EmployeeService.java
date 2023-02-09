package com.springapp.springbootapp.service;

import java.util.List;

import com.springapp.springbootapp.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEpmloyees();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployee(Employee employee,long id);
	
	public void deleteEmployee(long id);
}
