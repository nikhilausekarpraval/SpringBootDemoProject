package com.example.demo.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.TaskDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
		
	@Column(name = "name")
	private String name;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "MmobileNo")
	private String mobileNo;
	
	@Column(name = "createdOnDt")
	private LocalDate createdOnDt;
	
	@Column(name = "createdBy")
	private String createdBy;
	
//	// Bi-directional relationship mapped by 'employee' in Task entity
//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<TaskDto> tasks;  // One employee can have many tasks
}
