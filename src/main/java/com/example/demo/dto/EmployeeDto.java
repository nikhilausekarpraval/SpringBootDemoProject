package com.example.demo.dto;
import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeDto {
	
	private int id;
	
	private String name;
	
	private String position;
	
	private String designation;
	
	private String email;
	
	private String mobileNo;
	
	private LocalDate createdOnDt;
	
	private String createdBy ;
	
}
