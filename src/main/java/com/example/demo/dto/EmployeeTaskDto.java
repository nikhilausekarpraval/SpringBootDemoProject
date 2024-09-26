package com.example.demo.dto;


import java.time.LocalDate;
import java.util.List;

import lombok.Data;


@Data
public class EmployeeTaskDto {
	
	private int id;
	
	private String name;
	
	private String position;
	
	private String designation;
	
	private String email;
	
	private String mobileNo;
	
	private String createdBy ;
	
	private LocalDate createdOnDt;
	
	private List<TaskDto> tasks;
	
}