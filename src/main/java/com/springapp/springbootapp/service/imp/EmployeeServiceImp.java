package com.springapp.springbootapp.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springapp.springbootapp.model.Employee;
import com.springapp.springbootapp.repository.EmployeeRepository;
import com.springapp.springbootapp.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	

	public EmployeeServiceImp(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}



	@Override
	public List<Employee> getAllEpmloyees() {
		return employeeRepository.findAll();
	}

}
