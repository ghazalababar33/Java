package com.example.Assignment;

import java.util.*;

public class Books {
    private String title;
    private String author;
    private Metadata metadata;

    public Books(String title, String author, Metadata metadata) {
        this.title = title;
        this.author = author;
        this.metadata = metadata;
    }

    //Setters for All the Attributes

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
    //Getters for All the Attributes
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }

    public Metadata getMetadata() {
        return metadata;
    }

   //Display Function for printing the Detail of All the book
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + metadata.getPrice());
        System.out.println("Categories: " + String.join(", ", metadata.getCategories()));
        System.out.println("ISBN: " + metadata.getISBN());
        System.out.println("Number of Pages: " + metadata.getno_of_Pages());
    }
}

    
