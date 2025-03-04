package com.ashutosh.taskmanager.transformer;

import com.ashutosh.taskmanager.dto.CreateTaskDTO;
import com.ashutosh.taskmanager.entities.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateTaskDtoToTask {
    private final SimpleDateFormat deadLineFormatter = new SimpleDateFormat("YYYY-MM-dd");
    public Task transformCreateTaskDtoToTask(CreateTaskDTO dto) throws ParseException {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        if(dto.getDeadline() != null) {
            task.setDeadline(deadLineFormatter.parse(dto.getDeadline()));
        }
        return task;
    }
}
