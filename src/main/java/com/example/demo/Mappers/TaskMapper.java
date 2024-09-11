package com.example.demo.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.dto.EmployeeTaskDto;
import com.example.demo.dto.TaskDto;
import com.example.demo.entity.Task;

@Mapper(componentModel = "spring")
public abstract class TaskMapper {

   public abstract Task taskDtoToTask(TaskDto employeeDto);

   public abstract TaskDto taskToTaskDto(Task employee);
   
}