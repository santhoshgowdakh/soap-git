package com.employee.soapexample.endpoint;

import com.employee.soapexample.interfaces.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.employee.soapexample.model.Employee;
import com.employee.soapexample.service.EmployeeService;



@Endpoint
public class EmployeeEndpoint {

	private static final String NAMESPACE_URI = "http://employee.com/soapexample/interfaces";

	@Autowired
	private EmployeeService employeeService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	@ResponsePayload
	public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {

		AddEmployeeResponse response = new AddEmployeeResponse();
		ServiceStatus serviceStatus = new ServiceStatus();

		Employee employee = new Employee();
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
		employeeService.addEmployee(employee);
		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Content Added Successfully");
		response.setServiceStatus(serviceStatus);
		return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		EmployeeInfo employeeInfo = new EmployeeInfo();
		BeanUtils.copyProperties(employeeService.getEmployeeById(request.getEmployeeId()), employeeInfo);
		response.setEmployeeInfo(employeeInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
	@ResponsePayload
	public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
		employeeService.addEmployee(employee);
		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Employee Updated Successfully");
		UpdateEmployeeResponse response = new UpdateEmployeeResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeByIdRequest")
	@ResponsePayload
	public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeByIdRequest request) {
		employeeService.deleteEmployee(request.getEmployeeId());
		ServiceStatus serviceStatus = new ServiceStatus();

		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Employee Deleted Successfully");
		DeleteEmployeeResponse response = new DeleteEmployeeResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}
	


	

}
