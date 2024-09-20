package com.example.demo.controllers;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mappers.EmployeeMapper;
import com.example.demo.dto.CommonApiResponse;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeResponse;
import com.example.demo.dto.EmployeeResponseDto;
import com.example.demo.dto.EmployeeTaskDto;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("api/employee/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private  EmployeeMapper employeeMapper;
	
	@PostMapping("register")
	@ManagedOperation(description = "Api to register Employee")
	public ResponseEntity<CommonApiResponse> employeeRegister(@RequestBody EmployeeDto employeeDto) {

		CommonApiResponse response = new CommonApiResponse();
		Employee registerEmployee = this.employeeService.addEmployee(employeeDto);
		
		if (registerEmployee != null) {
			response.setSuccess(true);
			response.setResponseMessage(employeeDto.getName() + " Registered Successfully");
			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.OK);
		}

		response.setSuccess(true);
		response.setResponseMessage("Failed to Register " + employeeDto.getName() + " Employee");
		return new ResponseEntity<CommonApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@DeleteMapping("delete")
	@ManagedOperation(description = "Api to delete the Employee")
	public ResponseEntity<CommonApiResponse> deleteEmployee(@RequestParam int employeeId) {

		CommonApiResponse response = new CommonApiResponse();
		
		this.employeeService.deleteEmployee(employeeId);  

		response.setSuccess(true);
		response.setResponseMessage("Employee deleted successfully");
		return new ResponseEntity<CommonApiResponse>(response, HttpStatus.OK);
		

	}
	
	@GetMapping("get")
	public ResponseEntity<EmployeeResponseDto> getAllEmployee() {
		
		EmployeeResponseDto response = new EmployeeResponseDto();
		List<Employee> employees = this.employeeService.getAllEmployees();
		List<EmployeeTaskDto> employeeTaskDtos = employees.stream().map(employeeMapper::employeeToEmployeeTaskDto).collect(Collectors.toList());
		response.setEmployees(employeeTaskDtos);
		response.setSuccess(true);
		response.setResponseMessage("employees fetched successfully");
		return new ResponseEntity<EmployeeResponseDto>(response, HttpStatus.OK);
	}
	
//	@GetMapping("getAll")
//	public ResponseEntity<EmployeeResponse> getOnlyEmployee() {
//		
//		EmployeeResponse response = new EmployeeResponse();
//		List<EmployeeDto> employees = this.employeeService.getOnlyEmployees();
//		response.setEmployees(employees);
//		response.setSuccess(true);
//		response.setResponseMessage("employees fetched successfully");
//		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
//	}
	
	@PutMapping("update")
	@ManagedOperation(description = "Api to update Employee")
	public ResponseEntity<CommonApiResponse> updateEmployee(@RequestBody EmployeeDto employeeDto) {

		CommonApiResponse response = new CommonApiResponse();
		Employee registerEmployee = this.employeeService.updateEmployee(employeeDto);
		
		if (registerEmployee != null) {
			response.setSuccess(true);
			response.setResponseMessage(employeeDto.getName() + " Updated Successfully");
			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.OK);
		}

		response.setSuccess(true);
		response.setResponseMessage("Failed to Update " + employeeDto.getName() + " Employee");
		return new ResponseEntity<CommonApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
