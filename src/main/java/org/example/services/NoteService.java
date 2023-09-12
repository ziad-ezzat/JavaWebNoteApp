package org.example.services;

import org.example.repos.NoteRepo;
import org.example.entities.Note;

import java.util.List;

public class NoteService {

    NoteRepo noteRepo = new NoteRepo();

    public void save(Note note) {
        noteRepo.save(note);
    }

    public void delete(Long id) {
        noteRepo.delete(id);
    }

    public void update(Note note) {
        noteRepo.update(note);
    }

    public List<Note> findAll() {
        return noteRepo.findAll();
    }

    public void findByTitle(String title) {
        noteRepo.findByTitle(title).forEach(System.out::println);
    }

    public Note findById(Long id) {
        return noteRepo.findById(id);
    }
}
