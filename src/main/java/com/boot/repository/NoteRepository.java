package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boot.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{
	
}
