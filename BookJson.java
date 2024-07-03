package com.example.Assignment;
import java.util.*;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.io.Reader;

public class BookJson {

    public static List<Books> parseBooksJson(String filePath) {
        Gson gson = new Gson();
        try (Reader reader = new InputStreamReader(BookJson.class.getResourceAsStream(filePath))) {
            BookList bookList = gson.fromJson(reader, BookList.class);
            return bookList.getBooks();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
