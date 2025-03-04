package com.ashutosh.taskmanager.service;

import com.ashutosh.taskmanager.dto.CreateTaskDTO;
import com.ashutosh.taskmanager.entities.Task;
import com.ashutosh.taskmanager.transformer.CreateTaskDtoToTask;
import com.ashutosh.taskmanager.utils.Validator;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Service

public class TaskService {
    private ArrayList<Task> tasks = new ArrayList<>();
    private int taskId = 1;
    private final SimpleDateFormat deadLineFormatter = new SimpleDateFormat("YYYY-MM-dd");
    public Task addTask(CreateTaskDTO dto) throws ParseException {
        Boolean result = Validator.validateTaskDto(dto);
        CreateTaskDtoToTask converter = new CreateTaskDtoToTask();
        Task task = converter.transformCreateTaskDtoToTask(dto);
        task.setId(taskId);
        task.setCompleted(false);
        tasks.add(task);
        taskId++;
        return task;
    }
    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public Task getTaskById(int id){
        for(Task task: tasks){
            if(task.getId()== id){
                return task;
            }
        }
        return null;
    }

    public Task updateTask(int id, String description, String deadline, Boolean completed) throws ParseException {
        Task task = getTaskById(id);
        if(task == null)
                return null;
        if(description!=null){
            task.setDescription(description);
        }
        if(deadline !=null)
            task.setDeadline(deadLineFormatter.parse(deadline));
        if(completed !=null){
            task.setCompleted(completed);
        }
        return task;
    }

    public Task deleteTask(int id){
        Task task = getTaskById(id);
        if(task==null)
            return null;
        tasks.remove(task);
        return task;
    }
}
