package com.example.demo.dto;
import java.time.LocalDate;
import lombok.Data;

@Data
public class TaskDto {
	
	private int id;
	
	private int employeeId;
	
	private String name;
	
	private String description;
	
	private String status;
	
	private LocalDate assignedOnDt;
	
	private LocalDate endDate;

	private String createdBy ;
}
