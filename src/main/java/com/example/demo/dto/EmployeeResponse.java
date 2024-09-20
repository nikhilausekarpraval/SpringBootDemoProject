package com.example.demo.dto;

import java.util.List;
import com.example.demo.entity.Employee;
import lombok.Data;

@Data
public class EmployeeResponse extends CommonApiResponse {
	
	private List<EmployeeDto> employees;

}