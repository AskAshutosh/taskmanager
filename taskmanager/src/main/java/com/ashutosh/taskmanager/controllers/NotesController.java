package com.ashutosh.taskmanager.controllers;

import com.ashutosh.taskmanager.dto.CreateNoteDTO;
import com.ashutosh.taskmanager.dto.CreateNoteResponseDTO;
import com.ashutosh.taskmanager.entities.Note;
import com.ashutosh.taskmanager.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")

public class NotesController {
    private NoteService notesService;
    public NotesController(NoteService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("")
    public ResponseEntity<List<Note>> getNotes(@PathVariable("taskId") Integer taskId){
        var notes = notesService.getNotesForTask(taskId);
        return ResponseEntity.ok(notes);
    }
    @PostMapping()
    public ResponseEntity<CreateNoteResponseDTO> addNote(
            @PathVariable("taskId") Integer taskId, @RequestBody CreateNoteDTO body){
        var note = notesService.addNotesForTask(taskId, body.getTitle(), body.getBody());
        return ResponseEntity.ok(new CreateNoteResponseDTO(taskId, note));
    }
}
