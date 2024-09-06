package com.example.demo.dto;
import java.time.LocalDate;
import lombok.Data;

@Data
public class TasksDto {
	
	private int id;
	
	private int employeeID;
	
	private String name;
	
	private String description;
	
	private LocalDate assignedOnDt;
	
	private LocalDate endDate;

	private String createdBy ;
}
