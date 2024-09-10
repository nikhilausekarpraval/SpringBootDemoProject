package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mappers.EmployeeMapper;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private  EmployeeMapper employeeMapper;
	
	public Employee addEmployee(EmployeeDto employeeDto) {
		
		Employee employee = employeeMapper.employeeDtoToEmployee(employeeDto);
		return employeeDao.save(employee);
	}
	
	public Employee updateEmployee(EmployeeDto employeeDto) {
		Employee employee = employeeMapper.employeeDtoToEmployee(employeeDto);
		return employeeDao.save(employee);
	}
	
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}
	
	public void deleteEmployee(int employeeId) {
		 employeeDao.deleteById(employeeId);
	}
	
	public Employee getEmployeeById(int EmployeeId) {
		
		Employee empDto = null;
		
		Optional<Employee> emp = employeeDao.findById(EmployeeId);
		
		if(emp.isPresent()) {
			empDto = emp.get();
		}
		
		return empDto; 
	}
	
	public List<Employee> getAllEmployeesByEmployeeName(String EmployeeName) {
		return employeeDao.findByNameContainingIgnoreCase(EmployeeName);
	}
//	
//	public List<Employee> getAllEmployeesByEmployeeNameAndEmployeeId(String taskName, int taskId) {
//		return employeeDao.findByNameContainingIgnoreCaseAndTasksId(taskName, taskId);
//	}
	
////	public List<Employee> getAllEmployeesByEmployeeId(int taskId) {
//		return employeeDao.findByTasksId(taskId);
//	}
//	

}
