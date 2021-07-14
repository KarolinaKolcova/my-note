package com.app.model;

import com.app.model.enums.Categories;

public class Note {
    private String title;
    private String description;
    private User author;
    private Categories categories;

    public Note(String title, String description, User author, Categories categories) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
}
