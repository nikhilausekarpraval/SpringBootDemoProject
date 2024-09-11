package com.example.demo.entity;
import java.time.LocalDate;
import com.example.demo.dto.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
    @Column(name = "name")
	private String name;
	
    @Column(name = "description")
	private String description;
	
    @Column(name = "assignedOnDt")
	private LocalDate assignedOnDt;
	
    @Column(name = "endDate")
	private LocalDate endDate;
	
    @Column(name = "createdOnDt")
	private LocalDate createdOnDt;
	
    @Column(name="createdBy")
	private String createdBy;
    
    @ManyToOne
    @JoinColumn(name = "employeeId") // This will create the foreign key column in the Task table
    private Employee employee;
}
