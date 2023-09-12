package org.example.rest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entities.Note;
import org.example.services.NoteService;

import java.io.IOException;

@WebServlet("/notes/*")
public class MyServlet extends HttpServlet {

    NoteService noteService = new NoteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getPathInfo();
        String[] pathParts = path.split("/");
        String currentPath = pathParts[1];
        System.out.println(currentPath);
        switch (currentPath) {
            case "home" -> {
                req.setAttribute("notes", noteService.findAll());
                req.getRequestDispatcher("/ListNote.jsp").forward(req, resp);
            }
            case "add" -> {
                req.getRequestDispatcher("/AddNote.jsp").forward(req, resp);
            }
            case "delete" -> {
                Long id = Long.parseLong(pathParts[2]);
                noteService.delete(id);
                resp.sendRedirect(getServletContext().getContextPath()+"/notes/home");
            }
            case "edit" -> {
                Long id = Long.parseLong(pathParts[2]);
                Note note = noteService.findById(id);
                req.setAttribute("note", note);
                req.getRequestDispatcher("/UpdateNote.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getPathInfo();
        String[] pathParts = path.split("/");
        String currentPath = pathParts[1];
        System.out.println(currentPath);
        switch (currentPath) {
            case "addNote" -> {
                System.out.println("add entered");
                String title = req.getParameter("title");
                String content = req.getParameter("content");
                Note note = new Note();
                note.setTitle(title);
                note.setContent(content);
                noteService.save(note);
                resp.sendRedirect(getServletContext().getContextPath()+"/notes/home");
            }
            case "edit" -> {
                Long id = Long.parseLong(pathParts[2]);
                String title = req.getParameter("title");
                String content = req.getParameter("content");
                Note note = new Note();
                note.setId(id);
                note.setTitle(title);
                note.setContent(content);
                noteService.update(note);
                resp.sendRedirect(getServletContext().getContextPath()+"/notes/home");
            }
        }
    }
}
