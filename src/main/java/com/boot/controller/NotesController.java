package com.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Note;
import com.boot.repository.NoteRepository;

@RestController
@RequestMapping("api/v1/")
public class NotesController {
	@Autowired
	private NoteRepository notesRepository;
	
	@RequestMapping(value = "notes", method = RequestMethod.GET)
    public List<Note> list(){
        return notesRepository.findAll();
    }
	
	@RequestMapping(value = "notes", method = RequestMethod.POST)
    public Note create(@RequestBody Note note){
        return notesRepository.saveAndFlush(note);
    }

	@RequestMapping(value = "notes/{id}", method = RequestMethod.GET)
    public Note get(@PathVariable Long id){
        return notesRepository.findOne(id);
    }

	@RequestMapping(value = "notes/{id}", method = RequestMethod.PUT)
    public Note update(@PathVariable Long id, @RequestBody Note note){
        Note existingNote = notesRepository.findOne(id);
        BeanUtils.copyProperties(note, existingNote);
        return notesRepository.saveAndFlush(note);
    }

	
	@RequestMapping(value = "notes/{id}", method = RequestMethod.DELETE)
    public Note delete(@PathVariable Long id){
        Note existingNote = notesRepository.findOne(id);
        notesRepository.delete(existingNote);
        return existingNote;
    }



}
