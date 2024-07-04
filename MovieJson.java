package com.example.Assignment;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;

public class MovieJson {

    public static List<Movie> parseMoviesJson(String filePath) {
        Gson gson = new Gson();
        try (Reader reader = new InputStreamReader(MovieJson.class.getClassLoader().getResourceAsStream(filePath))) {
            MovieList movieList = gson.fromJson(reader, MovieList.class);
            return movieList.getMovies();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle error gracefully, maybe log or throw custom exception
        }
    }
}
