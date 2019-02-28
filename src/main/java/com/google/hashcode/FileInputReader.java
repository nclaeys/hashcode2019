package com.google.hashcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileInputReader {
    private int index = 0;

    public List<Photo> parse(String path) {
        try {
            return Files.lines(Paths.get(path))
                    .map(entry -> toPhoto(entry))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Photo toPhoto(String entry) {
        String[] entries = entry.split(" ");
        if(entries.length > 1) {
            int length = Integer.parseInt(entries[1]);
            List<String> tags = new ArrayList<>();
            for (int i= 0; i< length; i++) {
                tags.add(entries[2 + i]);
            }
            return new Photo(index++, entries[0], tags);
        } else {
            return null;
        }
    }
}
