package com.example.Assignment;

import java.util.ArrayList;
import java.util.List;

public class Library<T extends Media> {
    private List<T> mediaItems = new ArrayList<>();
    private List<LibraryObserver> observers = new ArrayList<>();

    public void addMedia(T media) {
        this.mediaItems.add(media);
        notifyObservers(new LibraryEvent("New media added", media));
    }

    public void updateMediaPrice(T media, double newPrice) {
        media.updatePrice(newPrice);
        notifyObservers(new LibraryEvent("Media price updated", media));
    }

    public void addObserver(LibraryObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(LibraryEvent event) {
        for (LibraryObserver observer : observers) {
            observer.updateEvent(event);
        }
    }

    public List<T> getAllMedia() {
        return new ArrayList<>(mediaItems); // Return a copy to prevent direct modification of internal list
    }

    // Other library methods as needed
}
