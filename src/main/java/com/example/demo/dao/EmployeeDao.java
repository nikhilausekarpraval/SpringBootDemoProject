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
	
	@Query("SELECT e FROM Employee e LEFT JOIN e.tasks t")
	List<Employee> findEmployeesWithTasksHavingEmployeeId();

//	 @Query("SELECT new Employee(e.id, e.name,e.description,e.position,e.email,e.mobileNo,e.createdBy,e.createdOnDt) FROM Employee e")
//	    List<EmployeeDto> findAllAsDto();
}

