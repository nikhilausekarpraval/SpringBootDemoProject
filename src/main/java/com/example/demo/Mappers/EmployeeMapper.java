package com.example.demo.Mappers;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeTaskDto;
import com.example.demo.entity.Employee;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {

   public abstract Employee employeeDtoToEmployee(EmployeeDto employeeDto);

   public abstract EmployeeDto employeeToEmployeeDto(Optional<Employee> employee);
   
   public abstract EmployeeTaskDto employeeToEmployeeTaskDto(Employee employee);
}