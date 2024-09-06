package com.example.demo.dto;
import java.util.List;
import com.example.demo.entity.Employee;
import lombok.Data;

@Data
public class EmployeesResponseDto extends CommonApiResponse {
	
	private List<Employee> employees;

}
