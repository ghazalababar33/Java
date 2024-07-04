package com.example.Assignment;

public class LibraryEvent {
    private String message;
    private Media media;

    public LibraryEvent(String message, Media media) {
        this.message = message;
        this.media = media;
    }

    public String getMessage() {
        return message;
    }

    public Media getMedia() {
        return media;
    }
}
