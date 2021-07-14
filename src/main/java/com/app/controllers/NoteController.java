package com.app.controllers;

import com.app.model.enums.Categories;
import com.app.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes")
    public String getAllNotes(Model model) {
        model.addAttribute("notes", noteService.getNotes(10));
        return "notes";
    }

    @GetMapping("/notes/{categories}")
    public String getNotesByCategories(@PathVariable(value = "categories") Categories categories, Model model) {
        model.addAttribute("notes", noteService.filterByCategories(categories));
        return "notes";
    }
}
