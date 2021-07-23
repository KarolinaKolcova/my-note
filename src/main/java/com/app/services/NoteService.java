package com.app.services;

import com.app.dao.NoteDao;
import com.app.model.Note;
import com.app.model.User;
import com.app.model.enums.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteDao noteDao;
    public List<Note> getNotes() {
        return noteDao.getAllNotes();
    }

    public List<Note> filterByCategories(Categories categories) {
        List<Note> notes = new ArrayList<>();

        for (Note note : getNotes()) {
            if (note.getCategories()== categories) {
                notes.add(note);
            }
        }

        return notes;
    }

    public String validate(Note note) {
        if (note.getTitle() == null || note.getTitle().isEmpty()) {
            return "Title can't be empty";
        }

        if (note.getDescription() == null || note.getDescription().isEmpty()) {
            return "Description can't be empty";
        }

        if (note.getTitle().length() <5) {
            return "Title must be at least 10 chars";
        }

        if (note.getTitle().length() >132) {
            return "Title can't contain more than 132 chars";
        }

        noteDao.storeNote(note);
        return null;
    }
}
