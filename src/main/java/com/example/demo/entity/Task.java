package com.example.demo.entity;
import java.time.LocalDate;
import com.example.demo.dto.EmployeeDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    
    // Foreign Key: Many tasks belong to one employee
//    @ManyToOne(fetch = FetchType.LAZY, optional = true) // Foreign key column can be null
//    @JoinColumn(name = "employee_id", referencedColumnName = "id") // This maps the foreign key column 'employee_id' to Employee's 'id'
//    private Employee employee;  // This is the foreign key relation
}
