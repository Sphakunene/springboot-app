package com.springapp.springbootapp.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.springbootapp.exception.ResourceNotFoundException;
import com.springapp.springbootapp.model.Employee;
import com.springapp.springbootapp.repository.EmployeeRepository;
import com.springapp.springbootapp.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
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



	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
		
	}



	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee employeeExist = employeeRepository.findById(id).orElseThrow(()->new 
				ResourceNotFoundException("Employee", "Id", id));
		employeeExist.setFirstName(employee.getFirstName());
		employeeExist.setLastName(employee.getLastName());
		employeeExist.setEmail(employee.getEmail());
		employeeRepository.save(employeeExist);
		return employeeExist;
	}



	@Override
	public void deleteEmployee(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
		employeeRepository.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	
	}
	
	

}
