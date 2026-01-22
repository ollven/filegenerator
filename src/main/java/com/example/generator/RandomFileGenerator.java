package com.example.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class RandomFileGenerator {

    private static final int LINES_COUNT = 3;
    private static final int LINE_LENGTH = 8;
    private static final String CHARACTERS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static void main(String[] args) throws IOException {
        String content = generateContent();

        Path outputDir = Path.of("output");
        Path outputFile = outputDir.resolve("random.txt");

        Files.createDirectories(outputDir);
        Files.writeString(outputFile, content);

        System.out.println("Generated file: " + outputFile.toAbsolutePath());
        System.out.println("Content:");
        System.out.println(content);
    }

    private static String generateContent() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int line = 0; line < LINES_COUNT; line++) {
            for (int i = 0; i < LINE_LENGTH; i++) {
                result.append(
                        CHARACTERS.charAt(random.nextInt(CHARACTERS.length()))
                );
            }
            if (line < LINES_COUNT - 1) {
                result.append(System.lineSeparator());
            }
        }
        return result.toString();
    }
}
