package com.example.Assignment;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;

public class MagazineJson {

    public static List<Magazine> parseMagazinesJson(String filePath) {
        Gson gson = new Gson();
        try (Reader reader = new InputStreamReader(MagazineJson.class.getClassLoader().getResourceAsStream(filePath))) {
            MagazineList magazineList = gson.fromJson(reader, MagazineList.class);
            return magazineList.getMagazines();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle error gracefully, maybe log or throw custom exception
        }
    }
}
