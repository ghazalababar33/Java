package com.example.Assignment;

import java.util.*;
import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.io.Reader;

public class BookJsons {

    public static List<Books> parseBooksJson(String filePath) {
        Gson gson = new Gson();
        try (Reader reader = new InputStreamReader(BookJsons.class.getResourceAsStream(filePath))) {
            BookLists bookList = gson.fromJson(reader, BookLists.class);
            return bookList.getBooks();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
