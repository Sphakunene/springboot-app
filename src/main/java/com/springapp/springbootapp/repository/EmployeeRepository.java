package com.springapp.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springapp.springbootapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
