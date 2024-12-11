package com.spacetravel.spring_15.repository;

import com.spacetravel.spring_15.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}

