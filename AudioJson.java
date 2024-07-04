package com.example.Assignment;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;

public class AudioJson {

    public static List<AudioBook> parseAudioBooksJson(String filePath) {
        Gson gson = new Gson();
        try (Reader reader = new InputStreamReader(AudioJson.class.getClassLoader().getResourceAsStream(filePath))) {
            AudioBookList audioBookList = gson.fromJson(reader, AudioBookList.class);
            return audioBookList.getAudioBooks();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle error gracefully, maybe log or throw custom exception
        }
    }
}
