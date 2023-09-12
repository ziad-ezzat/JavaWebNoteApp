package org.example.repos;

import org.example.AppDatabase;
import org.example.entities.Note;
import org.hibernate.Session;

import java.util.List;

public class NoteRepo {

    private final AppDatabase appDatabase;
    private Session session;

    public NoteRepo() {
        appDatabase = new AppDatabase();
    }

    private void openSession() {
        session = appDatabase.openSession();
    }

    private void closeSession() {
        session.close();
    }

    public void save(Note note) {
        openSession();
        session.beginTransaction();
        session.save(note);
        session.getTransaction().commit();
        closeSession();
    }

    public List<Note> findAll() {
        openSession();
        List<Note> notes = session.createQuery("from Note", Note.class).list();
        closeSession();
        return notes;
    }

    public void delete(Long id) {
        openSession();
        session.beginTransaction();
        Note note = session.get(Note.class, id);
        session.delete(note);
        session.getTransaction().commit();
        closeSession();
    }

    public void update(Note note) {
        openSession();
        session.beginTransaction();
        session.update(note);
        session.getTransaction().commit();
        closeSession();
    }

    public List<Note> findByTitle(String title) {
        openSession();
        List<Note> notes = session.createQuery("from Note where title = :title", Note.class)
                .setParameter("title", title)
                .list();
        closeSession();
        return notes;
    }

    public Note findById(Long id) {
        openSession();
        Note note = session.get(Note.class, id);
        closeSession();
        return note;
    }
}
