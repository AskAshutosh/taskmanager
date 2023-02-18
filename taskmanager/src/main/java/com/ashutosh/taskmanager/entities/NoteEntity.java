package com.ashutosh.taskmanager.entities;

import lombok.Data;

@Data
public class NoteEntity {
    private int id;
    private String title;
    private String body;
}
