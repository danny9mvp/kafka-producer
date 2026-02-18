package com.dannymvp.producer.utils;

import tools.jackson.databind.ObjectMapper;

import java.nio.file.Path;

public class FileUtils {
    private static final String FILE_PATH = "src/test/resources/";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> T readJsonFile(String fileName, Class<T> clazz) {
        return OBJECT_MAPPER.readValue(Path.of(FILE_PATH.concat(fileName)), clazz);
    }
}
