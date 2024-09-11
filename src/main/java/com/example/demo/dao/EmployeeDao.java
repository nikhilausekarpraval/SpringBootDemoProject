package com.example.demo.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;


@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByNameContainingIgnoreCase(String name);
//	List<Employee> findByNameContainingIgnoreCaseAndTasksId(String taskName, int task);
	
	@Query("SELECT e FROM Employee e JOIN e.tasks t WHERE t.employee.id = e.id")
	List<Employee> findEmployeesWithTasksHavingEmployeeId();

}
