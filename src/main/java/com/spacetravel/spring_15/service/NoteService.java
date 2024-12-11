package com.spacetravel.spring_15.service;

import com.spacetravel.spring_15.model.Note;
import com.spacetravel.spring_15.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;


    public List<Note> findAll() {
        return noteRepository.findAll();
    }


    public Note findById(Long id) {
        Optional<Note> note = noteRepository.findById(id);
        return note.orElseThrow(() -> new RuntimeException("Note not found"));
    }


    public Note save(Note note) {
        return noteRepository.save(note);
    }


    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}
