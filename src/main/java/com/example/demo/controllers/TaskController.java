package com.example.demo.controllers;
import java.time.LocalDate;
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

import com.example.demo.Mappers.TaskMapper;
import com.example.demo.dto.CommonApiResponse;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeTaskDto;
import com.example.demo.dto.TaskDto;
import com.example.demo.dto.TasksResponseDto;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Task;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.TaskService;

@RestController
@CrossOrigin
@RequestMapping("task/")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private TaskMapper taskMapper;
	
	@PostMapping("register")
	@ManagedOperation(description = "Api to register Task")
	public ResponseEntity<CommonApiResponse> TaskRegister(@RequestBody TaskDto taskDto) {
		
		CommonApiResponse response = new CommonApiResponse();

		Task task = taskMapper.taskDtoToTask(taskDto);
		
		Employee employee = this.employeeService.getEmployeeById(taskDto.getEmployeeId());

	      if (employee != null ) {
	    	  task.setEmployee(employee);
	      }
		
		Task registerTask = this.taskService.addTask(task);
		
		if (registerTask != null) {
			response.setSuccess(true);
			response.setResponseMessage(task.getName() + " Registered Successfully");
			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.OK);
		}

		response.setResponseMessage("Failed to Register " + task.getName() + " Task");
		return new ResponseEntity<CommonApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@DeleteMapping("delete")
	@ManagedOperation(description = "Api to delete the Task")
	public ResponseEntity<CommonApiResponse> deleteTask(@RequestParam int taskId) {

		CommonApiResponse response = new CommonApiResponse();
		
		this.taskService.deleteTask(taskId);  

		response.setSuccess(true);
		response.setResponseMessage("Task deleted successfully");
		return new ResponseEntity<CommonApiResponse>(response, HttpStatus.OK);
		

	}
	
	@GetMapping("get")
	public ResponseEntity<TasksResponseDto> getAllTask() {
		
		TasksResponseDto response = new TasksResponseDto();
		List<Task> tasks = this.taskService.getAllTasks();
		List<TaskDto> taskDtos = tasks.stream().map(taskMapper::taskToTaskDto).collect(Collectors.toList());
		response.setTasks(taskDtos);
		response.setSuccess(true);
		response.setResponseMessage("Tasks fetched successfully");
		return new ResponseEntity<TasksResponseDto>(response, HttpStatus.OK);
	}
	
	@PutMapping("update")
	@ManagedOperation(description = "Api to update Task")
	public ResponseEntity<CommonApiResponse> updateTask(@RequestBody TaskDto taskDto) {

		CommonApiResponse response = new CommonApiResponse();
		Task task = taskMapper.taskDtoToTask(taskDto);
        
		Employee employee = this.employeeService.getEmployeeById(taskDto.getEmployeeId());

	      if (employee == null ) {
	          return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	      }
	      task.setEmployee(employee);
	      
		Task updateTask = this.taskService.updateTask(task);
		
		if (updateTask != null) {
			response.setSuccess(true);
			response.setResponseMessage(taskDto.getName() + " Updated Successfully");
			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.OK);
		}

		response.setSuccess(true);
		response.setResponseMessage("Failed to Update " + taskDto.getName() + " Task");
		return new ResponseEntity<CommonApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
