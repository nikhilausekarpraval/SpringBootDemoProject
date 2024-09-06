package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public Employee addEmployee(Employee Employee) {
		return employeeDao.save(Employee);
	}
	
	public Employee updateEmployee(Employee Employee) {
		return employeeDao.save(Employee);
	}
	
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}
	
	public void deleteEmployee(int employeeId) {
		 employeeDao.deleteById(employeeId);
	}
	
	public Employee getEmployeeById(int EmployeeId) {
		
		Employee p = null;
		
		Optional<Employee> oP = employeeDao.findById(EmployeeId);
		
		if(oP.isPresent()) {
			p = oP.get();
		}
		
		return p;
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
