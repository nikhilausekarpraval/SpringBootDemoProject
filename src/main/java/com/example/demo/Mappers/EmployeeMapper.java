package com.example.demo.Mappers;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeTaskDto;
import com.example.demo.dto.TaskDto;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Task;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {

   public abstract Employee employeeDtoToEmployee(EmployeeDto employeeDto);

   public abstract EmployeeDto employeeToEmployeeDto(Optional<Employee> employee);
   
   @Mapping(source = "employee.id", target = "employeeId")
   public abstract TaskDto taskToEmployeeTaskDto(Task task);
   
   @Mapping(target = "tasks", source = "tasks")
   public abstract EmployeeTaskDto employeeToEmployeeTaskDto(Employee employee);
   
}