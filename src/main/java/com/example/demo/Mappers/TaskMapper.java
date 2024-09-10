package com.example.demo.Mappers;

import org.mapstruct.Mapper;
import com.example.demo.dto.TaskDto;
import com.example.demo.entity.Task;

@Mapper(componentModel = "spring")
public abstract class TaskMapper {

   public abstract Task employeeDtoToEmployee(TaskDto employeeDto);

   public abstract TaskDto employeeToEmployeeDto(Task employee);
}