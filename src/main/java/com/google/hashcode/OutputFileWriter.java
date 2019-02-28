package com.google.hashcode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputFileWriter {

    private final List<Slide> slides;

    public OutputFileWriter(List<Slide> slides) {
        this.slides = slides;
    }

    public void write() throws IOException {
        final StringBuilder stringBuilder = new StringBuilder();
        for (Slide slide : slides) {
            stringBuilder.append(slide.toString()).append("\n");
        }

        final BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write(stringBuilder.toString());
        writer.close();
    }
}
