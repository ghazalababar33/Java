package com.example.Assignment;

import java.util.List;

public class AudioBook implements Media {
    private double price;
    private String title;
    private String narrator;
    private List<String> categories;

    public AudioBook(double price, String title, String narrator, List<String> categories) {
        this.price = price;
        this.title = title;
        this.narrator = narrator;
        this.categories = categories;
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

    public String getNarrator() {
        return narrator;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
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
		return MediaType.AUDIO_BOOK;
	}

}
