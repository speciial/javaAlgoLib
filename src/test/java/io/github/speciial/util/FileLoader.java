package io.github.speciial.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class FileLoader {

    private FileLoader() { }

    public static int[] loadNumbersToArray(String fileName) {
        int[] result = null;

        Path path;
        Scanner scanner;
        try {
            path = Paths.get(Objects.requireNonNull(FileLoader.class.getClassLoader().getResource(fileName)).toURI());
            scanner = new Scanner(path, StandardCharsets.UTF_8);

            int elemAnzahl = scanner.nextInt();
            result = new int[elemAnzahl];

            int index = 0;
            while (scanner.hasNextInt()) {
                result[index] = scanner.nextInt();
                ++index;
            }

            scanner.close();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static ArrayList<Integer> loadNumbersToArrayList(String fileName) {
        ArrayList<Integer> result = null;

        Path path;
        Scanner scanner;
        try {
            path = Paths.get(Objects.requireNonNull(FileLoader.class.getClassLoader().getResource(fileName)).toURI());
            scanner = new Scanner(path, StandardCharsets.UTF_8);

            int elemAnzahl = scanner.nextInt();
            result = new ArrayList<>(elemAnzahl);

            while (scanner.hasNextInt()) {
                result.add(scanner.nextInt());
            }

            scanner.close();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return result;
    }

}
