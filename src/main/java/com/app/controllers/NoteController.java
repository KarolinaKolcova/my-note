package com.app.controllers;

import com.app.model.Note;
import com.app.model.enums.Categories;
import com.app.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes")
    public String getAllNotes(Model model) {
        model.addAttribute("notes", noteService.getNotes());
        return "notes";
    }

    @GetMapping("/notes/{categories}")
    public String getNotesByCategories(@PathVariable(value = "categories") Categories categories, Model model) {
        model.addAttribute("notes", noteService.filterByCategories(categories));
        return "notes";
    }

    @GetMapping("/notes/new")
    public String getNewNotesPage(Model model) {
        model.addAttribute("note", new Note());
        return "newNote";
    }

    @PostMapping("/notes/new")
    public String createNewNote(@ModelAttribute Note note, Model model) {
       String validationResult = noteService.validate(note);
        if (validationResult == null) {
            return "redirect:/notes";
        } else {
            model.addAttribute("error", validationResult);
            model.addAttribute("note", note);
            return "newNote";
        }
    }
}
