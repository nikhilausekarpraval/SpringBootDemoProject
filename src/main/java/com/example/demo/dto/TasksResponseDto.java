package com.example.demo.dto;
import java.util.List;
import com.example.demo.entity.Task;
import lombok.Data;

@Data
public class TasksResponseDto extends CommonApiResponse {
	
	private List<Task> tasks;

}
