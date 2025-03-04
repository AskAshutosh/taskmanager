package com.ashutosh.taskmanager.utils;

import com.ashutosh.taskmanager.dto.CreateTaskDTO;
import com.ashutosh.taskmanager.entities.Task;

public class Validator {
    public static boolean validateTaskDto(CreateTaskDTO dto) {
        if(dto.getTitle() == null || dto.getTitle().isEmpty()) {
            return false;
        }
        return true;
    }
}
