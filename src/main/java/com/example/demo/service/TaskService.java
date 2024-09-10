package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mappers.EmployeeMapper;
import com.example.demo.Mappers.TaskMapper;
import com.example.demo.dao.TaskDao;
import com.example.demo.dto.TaskDto;
import com.example.demo.entity.Task;


@Service
public class TaskService {

	@Autowired
	private TaskDao taskDao;
	
	public Task addTask(Task task) {
		return taskDao.save(task);
	}
	
	public Task updateTask(Task task) {
		return taskDao.save(task);
	}
	
	public List<Task> getAllTasks() {
		return taskDao.findAll();
	}
	
	public void deleteTask(int taskId) {
		taskDao.deleteById(taskId);
	}
	
//	public List<Task> getTaskByEmployeeId(String name) {
//		return this.taskDao.findByEmployeeId(name);
//	}
	
	public List<Task> getTaskByNameContainingIgnoreCase(String TaskName) {
		return this.taskDao.findByNameContainingIgnoreCase(TaskName);
	}
	
//	public Task getTaskById(int TaskId) {
//		return this.taskDao.findById(TaskId);
//	}
	
}
