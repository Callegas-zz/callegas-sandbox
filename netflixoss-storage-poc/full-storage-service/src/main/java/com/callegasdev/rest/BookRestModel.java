package com.callegasdev.rest;

public class BookRestModel {
    private String name;
    private String author;

    public BookRestModel(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return  "{name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
