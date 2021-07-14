package com.app.services;

import com.app.model.Note;
import com.app.model.User;
import com.app.model.enums.Categories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    public List<Note> getNotes(int count) {
        User author = new User("Maris", "lo", "mar@lo.lv");

        List<Note> notes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Note note = new Note("Title: " + i, "Description: " + i, author, Categories.GOL);
            notes.add(note);
        }

        notes.add(new Note("N1", "Little lunch", author, Categories.LIL));
        notes.add(new Note("N2", "Cold lunch", author, Categories.COL));
        return notes;
    }

    public List<Note> filterByCategories(Categories categories) {
        List<Note> notes = new ArrayList<>();

        for (Note note : getNotes(15)) {
            if (note.getCategories()== categories) {
                notes.add(note);
            }
        }

        return notes;
    }
}
