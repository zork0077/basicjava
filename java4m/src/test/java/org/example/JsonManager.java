package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void writeToJson(Object object, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(object, writer);
        }
    }

    public static <T> T readFromJson(Class<T> classOfT, String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, classOfT);
        }
    }
}
