package com.employee.soapexample.service;

import com.employee.soapexample.model.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	void updateEmployee(Employee employee);

	Employee getEmployeeById(int employeeId);

	void deleteEmployee(int employeeId);

}
