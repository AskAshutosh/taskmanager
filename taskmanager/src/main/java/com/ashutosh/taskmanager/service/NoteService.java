package com.ashutosh.taskmanager.service;

import com.ashutosh.taskmanager.entities.Note;
import com.ashutosh.taskmanager.entities.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NoteService {
    private final TaskService taskService;
    private final HashMap<Integer, TaskNotesHolder> taskNotesHolders = new HashMap<>();
    public NoteService(TaskService taskService) {
        this.taskService = taskService;
    }


    class TaskNotesHolder{
        protected int nodeId = 1;
        protected ArrayList<Note> notes = new ArrayList<>();
    }
    public List<Note> getNotesForTask(int taskId){
        Task task = taskService.getTaskById(taskId);
        if(task == null)
            return null;
        if(taskNotesHolders.get(taskId)==null) {
            taskNotesHolders.put(taskId, new TaskNotesHolder());
        }
        return taskNotesHolders.get(taskId).notes;
    }
    public Note addNotesForTask(int taskId, String title, String body){
        Task task = taskService.getTaskById(taskId);
        if(task == null)
            return null;
        if(taskNotesHolders.get(taskId)==null){
            taskNotesHolders.put(taskId, new TaskNotesHolder());
        }
        TaskNotesHolder taskNotesHolder = taskNotesHolders.get(taskId);
        Note note = new Note();
        note.setId(taskNotesHolder.nodeId);
        note.setTitle(title);
        note.setBody(body);
        taskNotesHolder.notes.add(note);
        taskNotesHolder.nodeId+=1;
        return note;
    }
}
