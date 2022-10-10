package com.employee.soapexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.soapexample.model.Employee;
import com.employee.soapexample.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeRepository.findByEmployeeId(employeeId);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
