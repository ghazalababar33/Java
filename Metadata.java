package com.example.Assignment;

import java.util.List;

public class Metadata {
    private double price;
    private List<String> categories;
    private String ISBN;
    private int no_of_Pages;

    public Metadata(double price, List<String> categories, String ISBN, int no_of_Pages) {
        this.price = price;
        this.categories = categories;
        this.ISBN = ISBN;
        this.no_of_Pages = no_of_Pages;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setNumberOfPages(int no_of_Pages) {
        this.no_of_Pages = no_of_Pages;
    }

    // Getters for All the Attributes of the class
    public double getPrice() {
        return price;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    public List<String> getCategories() {
        return categories;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getno_of_Pages() {
        return no_of_Pages;
    }
}
