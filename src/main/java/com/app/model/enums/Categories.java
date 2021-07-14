package com.app.model.enums;

public enum Categories {
    COL("Cold lunch"),
    DOUL("Double lunch"),
    GOL("Good lunch"),
    HOL("Hot lunch"),
    LIGL("Light lunch"),
    LIL("Little lunch");

    private String categories;

    Categories(String categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return categories;
    }
}
