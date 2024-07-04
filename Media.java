package com.example.Assignment;

public interface Media {
	void updatePrice(double newPrice);
    double getPrice();
	String getTitle();
	MediaType getType();
}
