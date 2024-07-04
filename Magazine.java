package com.example.Assignment;

import java.util.List;

public class Magazine implements Media {
    private double price;
    private String title;
    private String publisher;
    private List<String> categories;

    public Magazine(double price, String title, String publisher, List<String> categories) {
        this.price = price;
        this.title = title;
        this.publisher = publisher;
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

    public String getPublisher() {
        return publisher;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
		return MediaType.MAGAZINE;
	}

    // Other magazine-specific methods and properties
}
