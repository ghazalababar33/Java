package com.example.Assignment;

import java.util.List;

public class Movie implements Media {
    private double price;
    private String title;
    private String director;
    private List<String> categories;

    // Existing constructor
    public Movie(double price, String title, String director, List<String> categories) {
        this.price = price;
        this.title = title;
        this.director = director;
        this.categories = categories;
    }

    // New constructor
    public Movie(String title, String director, double price) {
        this.price = price;
        this.title = title;
        this.director = director;
        this.categories = List.of(); // Empty categories list
    }

    @Override
    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

	@Override
	public MediaType getType() {
		// TODO Auto-generated method stub
		return MediaType.MOVIE;
	}

    // Other movie-specific methods and properties
}
