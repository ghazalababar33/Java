package com.example.Assignment;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;

public class BookJson {

    public static List<Books> parseBooksJson(String filePath) {
        Gson gson = new Gson();
        try (Reader reader = new InputStreamReader(BookJson.class.getClassLoader().getResourceAsStream(filePath))) {
            BookList bookList = gson.fromJson(reader, BookList.class);
            return bookList.getBooks();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle error gracefully, maybe log or throw custom exception
        }
    }
}
