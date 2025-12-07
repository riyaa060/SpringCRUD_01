package com.example.riyadb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.riyadb.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	 
    Employee findByFirstName(String name);
 
}