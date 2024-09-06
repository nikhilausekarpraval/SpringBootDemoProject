package com.example.demo.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Task;

@Repository
public interface TaskDao extends JpaRepository<Task,Integer> {
	
	List<Task> findByNameContainingIgnoreCase(String employeeName);
//	List<Task> findByEmployeeId(String employeeId);
//	Task findById(int id);
	
}
